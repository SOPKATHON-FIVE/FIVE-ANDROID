package org.sopt.sopkathon5.andorid.data.model.response

data class ResponseDailyStore(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>
) {
    data class Data(
        val _id: String,
        val userId: Int,
        val userName: String,
        val dailyId: DailyId,
        val completeMissions: List<String>,
        val __v: Int
    ) {
        data class DailyId(
            val _id: String,
            val dailyName: String,
            val userId: Int,
            val userName: String,
            val missions: List<String>,
            val __v: Int
        )
    }
}