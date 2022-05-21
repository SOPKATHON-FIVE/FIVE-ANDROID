package org.sopt.sopkathon5.andorid.data.model

data class ResponseWrite (
    val status: String,
    val success : Boolean,
    val message : String,
    val data: List<Data>
    ) {
    data class Data(
        val _id: String
//    val dailyName: String,
//    val userId: Int,
//    val userName: String,
//    val missions: List<String>
    )
}