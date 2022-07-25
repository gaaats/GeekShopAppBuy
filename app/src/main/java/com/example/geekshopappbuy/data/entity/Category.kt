package com.example.retrofitrequestsimpletest1.api.response


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("caption")
    val caption: String?,
    @SerializedName("id")
    val id: Int?
)