package sjw.core.network.api.monkey

import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import sjw.core.network.ApiResponse
import sjw.core.network.api.monkey.model.MakerListResponse
import sjw.core.network.api.monkey.model.MobileModelDetailListResponse
import sjw.core.network.api.monkey.model.MobileTrendListResponse

interface MonkeyMobileApi {

    /** 제조사 목록. showAllMaker가 "Y"면 전체 제조사 포함 */
    @FormUrlEncoded
    @POST("_app/mobile/modeListMobileMaker")
    suspend fun getMakerList(
        @Field("tk_idx") tkIdx: Int = 1,
        @Field("showAllMaker") showAllMaker: String = "N",
    ): ApiResponse<MakerListResponse>

    /** 제조사별 트렌드 단말 목록 */
    @FormUrlEncoded
    @POST("_app/mobile/modeListMobile_trend")
    suspend fun getTrendList(
        @Field("tk_idx") tkIdx: Int,
        @Field("mk_idx") mkIdx: Int,
    ): ApiResponse<MobileTrendListResponse>

    /** 단말 상세 */
    @FormUrlEncoded
    @POST("_app/mobile/modeDetailData")
    suspend fun getModelDetail(
        @Field("tk_idx") tkIdx: Int,
        @Field("md_idx") mdIdx: Int,
    ): ApiResponse<MobileModelDetailListResponse>
}