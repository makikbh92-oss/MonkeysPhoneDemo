package sjw.core.network.api.monkey

import sjw.core.network.model.MobileTrendItemDto
import sjw.core.network.model.MobileTrendListResponse
import sjw.library.network.model.ApiResponse
import sjw.library.network.retrofit.NetworkRequestFactory
import timber.log.Timber
import javax.inject.Inject

class MonkeyMobileApi @Inject constructor(
    private val networkRequestFactory : NetworkRequestFactory
) {
    suspend fun getTrendList(tkIdx: Int, mkIdx: Int): List<MobileTrendItemDto> {
        val result = networkRequestFactory.create(
            url = "_app/mobile/modeListMobile_trend?tk_idx=$tkIdx&mk_idx=$mkIdx",
            serializer = MobileTrendListResponse.serializer(),
        )

        return when (val res = result.response) {
            is ApiResponse.Success -> res.data.list
            is ApiResponse.Fail -> {
                Timber.e(res.error, "trend list 실패 code=${result.code}")
                emptyList()
            }
        }
    }

}