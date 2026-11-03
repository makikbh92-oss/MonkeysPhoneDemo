package sjw.core.network

import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.io.IOException
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type


class ApiResponseCallAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit,
    ): CallAdapter<*, *>? {
        // suspend 함수는 Retrofit 내부에서 Call<ApiResponse<T>>로 전달됨
        if (getRawType(returnType) != Call::class.java) return null
        if (returnType !is ParameterizedType) return null

        val wrapperType = getParameterUpperBound(0, returnType)
        if (getRawType(wrapperType) != ApiResponse::class.java) return null
        require(wrapperType is ParameterizedType) {
            "ApiResponse는 ApiResponse<Foo> 형태로 타입을 지정해야 합니다."
        }

        val bodyType = getParameterUpperBound(0, wrapperType)
        return ApiResponseCallAdapter<Any>(bodyType)
    }
}

private class ApiResponseCallAdapter<R>(
    private val successType: Type,
) : CallAdapter<R, Call<ApiResponse<R>>> {
    override fun responseType(): Type = successType
    override fun adapt(call: Call<R>): Call<ApiResponse<R>> = ApiResponseCall(call, successType)
}

private class ApiResponseCall<R>(
    private val delegate: Call<R>,
    private val successType: Type,
) : Call<ApiResponse<R>> {

    override fun enqueue(callback: Callback<ApiResponse<R>>) {
        delegate.enqueue(object : Callback<R> {

            override fun onResponse(call: Call<R>, response: Response<R>) {
                callback.onResponse(
                    this@ApiResponseCall,
                    Response.success(response.toApiResponse()),
                )
            }

            // 네트워크 오류, 파싱 오류가 여기로 들어옴
            override fun onFailure(call: Call<R>, t: Throwable) {
                val failure = if (t is IOException) {
                    ApiResponse.Failure.NetworkError(t)
                } else {
                    ApiResponse.Failure.UnknownApiError(t)
                }
                callback.onResponse(this@ApiResponseCall, Response.success(failure))
            }
        })
    }

    private fun Response<R>.toApiResponse(): ApiResponse<R> {
        if (!isSuccessful) {
            return ApiResponse.Failure.HttpError(
                statusCode = code(),
                message = message(),
                body = errorBody()?.string().orEmpty(),
            )
        }

        body()?.let { return ApiResponse.Success(it) }

        // 반환 타입이 Unit이면 body가 없어도 성공
        return if (successType == Unit::class.java) {
            @Suppress("UNCHECKED_CAST")
            ApiResponse.Success(Unit as R)
        } else {
            ApiResponse.Failure.UnknownApiError(
                IllegalStateException("code ${code()}이지만 body가 null입니다.")
            )
        }
    }

    override fun clone(): Call<ApiResponse<R>> = ApiResponseCall(delegate.clone(), successType)
    override fun execute(): Response<ApiResponse<R>> =
        throw UnsupportedOperationException("동기 호출은 지원하지 않습니다. suspend 함수를 사용하세요.")
    override fun isExecuted(): Boolean = delegate.isExecuted
    override fun cancel() = delegate.cancel()
    override fun isCanceled(): Boolean = delegate.isCanceled
    override fun request(): Request = delegate.request()
    override fun timeout(): Timeout = delegate.timeout()
}