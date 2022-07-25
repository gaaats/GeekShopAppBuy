package com.example.retrofitrequestsimpletest1.api.response


import com.google.gson.annotations.SerializedName

data class Group(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?
)