package com.example.retrofitrequestsimpletest1.api.response


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("id")
    val id: Any?,
    @SerializedName("thumbnail_url")
    val thumbnailUrl: String?,
    @SerializedName("url")
    val url: String?
)