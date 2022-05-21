package org.sopt.sopkathon5.andorid.data.service

import org.sopt.sopkathon5.andorid.data.model.RequestWrite
import org.sopt.sopkathon5.andorid.data.model.ResponseWrite
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WriteService {
    @POST("daily/my")
    fun postWrite(
        @Body body: RequestWrite
    ): Call<ResponseWrite>
}