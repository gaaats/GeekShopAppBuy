package com.example.geekshopappbuy.data.remotedatasource

import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.geekshopappbuy.utils.SimpleResponse
import com.example.geekshopappbuy.data.entity.products.ResponseProductList
import com.example.geekshopappbuy.data.entity.singleproduct.ResponseSingleProduct

interface RemoteDataSource {


    suspend fun getAllProductsByGroupId(groupId: Int): SimpleResponse<ResponseProductList>

    suspend fun getProductInfo(productId: Int): SimpleResponse<ResponseSingleProduct>

    suspend fun getAllGroups(): SimpleResponse<ResultGroupSearch>
}