package com.example.geekshopappbuy.data

import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.retrofitrequestsimpletest1.api.response.GeekResponse
import retrofit2.Response
import retrofit2.http.*

interface SimpleAPI {


    @GET("products/list")
    suspend fun getProductsByGroupID(
        @Query("group_id") group_id: Int =98631214
    ): Response<GeekResponse>

    @GET("groups/list")
    suspend fun getAllGroups(
        @Query("limit") limit: Int =60
    ): Response<ResultGroupSearch>
}