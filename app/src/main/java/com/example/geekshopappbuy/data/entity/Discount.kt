package com.example.retrofitrequestsimpletest1.api.response


import com.google.gson.annotations.SerializedName

data class Discount(
    @SerializedName("date_end")
    val dateEnd: String?,
    @SerializedName("date_start")
    val dateStart: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("value")
    val value: Int?
)