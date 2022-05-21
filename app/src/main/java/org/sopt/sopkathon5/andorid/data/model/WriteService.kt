package org.sopt.sopkathon5.andorid.data.model

import org.sopt.sopkathon5.andorid.data.model.ResponseWrite
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface WriteService {
    @POST("daily")
    fun postWrite(
        @Body body: RequestWrite
    ): Call<ResponseWrite>
}