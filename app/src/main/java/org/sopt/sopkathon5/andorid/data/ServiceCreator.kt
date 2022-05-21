package org.sopt.sopkathon5.andorid.data

import org.sopt.sopkathon5.andorid.data.service.MyPageService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceCreator {
    private const val BASE_URL = "54.180.144.204:5001/"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val myPageService = retrofit.create(MyPageService::class.java)
}
