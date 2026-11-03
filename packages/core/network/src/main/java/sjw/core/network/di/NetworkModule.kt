package sjw.core.network.di


import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import sjw.core.network.ApiResponseCallAdapterFactory
import sjw.core.network.api.monkey.MonkeyMobileApi
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import retrofit2.converter.kotlinx.serialization.asConverterFactory



@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "http://imsi.monkeyphone.co.kr/"

    @Provides
    @Singleton
    fun provideJson(): Json = Json {
        ignoreUnknownKeys = true   // DTO에 없는 키는 무시
        coerceInputValues = true   // null이 오면 기본값 사용 (기본값이 있는 필드만)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
//            .addInterceptor(
////                HttpLoggingInterceptor().apply {
////                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
////                    else HttpLoggingInterceptor.Level.NONE
////                }
//            )
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(ApiResponseCallAdapterFactory())
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()

    @Provides
    @Singleton
    fun provideMonkeyMobileApi(retrofit: Retrofit): MonkeyMobileApi =
        retrofit.create(MonkeyMobileApi::class.java)
}