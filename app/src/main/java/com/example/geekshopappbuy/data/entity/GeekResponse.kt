package com.example.retrofitrequestsimpletest1.api.response


import com.google.gson.annotations.SerializedName

data class GeekResponse(
    @SerializedName("group_id")
    val groupId: Int?,
    @SerializedName("products")
    val products: List<Product?>?
)