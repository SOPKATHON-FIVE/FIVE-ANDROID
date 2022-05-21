package org.sopt.sopkathon5.andorid.data.service

import org.sopt.sopkathon5.andorid.data.model.response.ResponseDaily
import retrofit2.http.GET

interface ApiService {
    @GET("daily")
    suspend fun daily(): ResponseDaily
}