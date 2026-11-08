package sjw.library.network.di

import sjw.core.monkeysphone.compose.library.network.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import sjw.library.network.api.ApiService
import sjw.library.network.retrofit.NetworkRequestFactory
import sjw.library.network.retrofit.NetworkRequestFactoryImpl
import sjw.library.network.retrofit.StringConverterFactory
import timber.log.Timber
import javax.inject.Singleton



@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(interceptor)
        }
        return builder.build()
    }

    @Provides
    @Singleton
    fun provideJson(): Json {
        return Json{
            ignoreUnknownKeys = true
            coerceInputValues = true
        }
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(logBaseUrl(baseUrl = "http://imsi.monkeyphone.co.kr/"))
            .addConverterFactory(StringConverterFactory())
            .build()
    }

    private fun logBaseUrl(baseUrl: String): String {
        Timber.d("baseUrl $baseUrl")
        return baseUrl
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun bindNetworkRequestFactory(networkRequestFactory: NetworkRequestFactoryImpl): NetworkRequestFactory =
        networkRequestFactory

}










//@Module
//@InstallIn(SingletonComponent::class)
//object NetworkModule {
//
//    private const val BASE_URL = "http://imsi.monkeyphone.co.kr/"
//
//    @Provides
//    @Singleton
//    fun provideJson(): Json = Json {
//        ignoreUnknownKeys = true   // DTO에 없는 키는 무시
//        coerceInputValues = true   // null이 오면 기본값 사용 (기본값이 있는 필드만)
//    }
//
//    @Provides
//    @Singleton
//    fun provideOkHttpClient(): OkHttpClient =
//        OkHttpClient.Builder()
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
////            .addInterceptor(
//////                HttpLoggingInterceptor().apply {
//////                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
//////                    else HttpLoggingInterceptor.Level.NONE
//////                }
////            )
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideRetrofit(okHttpClient: OkHttpClient, json: Json): Retrofit =
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .client(okHttpClient)
//            .addCallAdapterFactory(ApiResponseCallAdapterFactory())
//            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
//            .build()
//
//    @Provides
//    @Singleton
//    fun provideMonkeyMobileApi(retrofit: Retrofit): MonkeyMobileApi =
//        retrofit.create(MonkeyMobileApi::class.java)
//}