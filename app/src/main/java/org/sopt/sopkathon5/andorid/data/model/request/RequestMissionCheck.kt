package org.sopt.sopkathon5.andorid.data.model.request

data class RequestMissionCheck(
    val _id: String,
    val userId: Int,
    val dailyId: String,
    val completeMissions: List<String>
)