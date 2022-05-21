package org.sopt.sopkathon5.andorid.data.service

import org.sopt.sopkathon5.andorid.data.model.response.ResponseDailyStore
import org.sopt.sopkathon5.andorid.data.model.response.ResponseMyDaily
import org.sopt.sopkathon5.andorid.data.model.response.ResponsePostMissionCheck
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST

interface MyPageService {
    @GET("daily/1")
    suspend fun getStoredDaily(): ResponseDailyStore

    @POST("daily/check")
    suspend fun postMissionCheck(): ResponsePostMissionCheck

    @GET("daily/my/2")
    suspend fun getMyDaily(): ResponseMyDaily
}
