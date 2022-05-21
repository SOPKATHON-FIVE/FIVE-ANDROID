package org.sopt.sopkathon5.andorid.data.model.response

data class ResponseStoreDaily(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val _id: String,
        val userId: Int,
        val userName: String,
        val dailyId: String,
        val completeMissions: List<List<String>>,
        val __v: Int
    )
}