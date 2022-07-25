package com.example.geekshopappbuy.domain.entitys

import com.google.gson.annotations.SerializedName

data class GeekGroupUI(
    val description: String,
    val id: Int,
    val image: String,
    val name: String,
    val parentGroupId: Int
)