package sjw.library.network.retrofit

import kotlinx.serialization.KSerializer
import sjw.library.network.model.ApiResult
import sjw.library.network.model.NetworkRequestInfo



interface NetworkRequestFactory {

    suspend fun <T> create(
        url: String,
        requestInfo: NetworkRequestInfo = NetworkRequestInfo.Builder().build(),
        serializer: KSerializer<T>
    ): ApiResult<T>
}