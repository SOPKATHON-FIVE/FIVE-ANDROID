package org.sopt.sopkathon5.andorid.data.service

import org.sopt.sopkathon5.andorid.data.model.response.ResponseStoreDaily
import retrofit2.Call
import retrofit2.http.GET

interface MyPageService {
    @GET("daily/1")
    fun getStoredDaily(): Call<ResponseStoreDaily>
}
