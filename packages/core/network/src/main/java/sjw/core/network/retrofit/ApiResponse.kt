package sjw.core.network

sealed interface ApiResponse<out T> {

    data class Success<T>(val data: T) : ApiResponse<T>

    sealed interface Failure : ApiResponse<Nothing> {
        /** 4xx, 5xx */
        data class HttpError(
            val statusCode: Int,
            val message: String,
            val body: String,
        ) : Failure

        /** 인터넷 끊김, 타임아웃 등 */
        data class NetworkError(val throwable: Throwable) : Failure

        /** JSON 파싱 오류 등 그 외 */
        data class UnknownApiError(val throwable: Throwable) : Failure
    }
}

inline fun <T> ApiResponse<T>.onSuccess(block: (T) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Success) block(data)
    return this
}

inline fun <T> ApiResponse<T>.onFailure(block: (ApiResponse.Failure) -> Unit): ApiResponse<T> {
    if (this is ApiResponse.Failure) block(this)
    return this
}