package org.sopt.sopkathon5.andorid.util

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <responseType> Call<responseType>.customEnqueue(
    Success: (Response<responseType>) -> Unit,
    Fail: () -> Unit = {}
) {
    this.enqueue(object : Callback<responseType> {
        override fun onFailure(call: Call<responseType>, t: Throwable) {
            Fail()
        }

        override fun onResponse(call: Call<responseType>, response: Response<responseType>) {
            if (response.isSuccessful) {
                Success(response)
                return
            }
        }
    })
}
