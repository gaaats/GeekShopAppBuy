package com.example.geekshopappbuy.data.remotedatasource

import com.example.geekshopappbuy.data.SimpleAPI
import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.geekshopappbuy.utils.SimpleResponse
import com.example.geekshopappbuy.data.entity.products.ResponseProductList
import com.example.geekshopappbuy.data.entity.singleproduct.ResponseSingleProduct
import retrofit2.Response
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val remoteAPi: SimpleAPI) :
    RemoteDataSource {
    override suspend fun getAllProductsByGroupId(groupId: Int): SimpleResponse<ResponseProductList> {
        return safeApiCall { remoteAPi.getProductsByGroupID(groupId) }
    }

    override suspend fun getProductInfo(productId: Int): SimpleResponse<ResponseSingleProduct> {
        return safeApiCall { remoteAPi.getProductInfo(productId) }
    }

    override suspend fun getAllGroups(): SimpleResponse<ResultGroupSearch> {
        return safeApiCall { remoteAPi.getAllGroups() }
    }


    private inline fun <T> safeApiCall(apiCall: () -> Response<T>): SimpleResponse<T> {
        return try {
            SimpleResponse.success(apiCall.invoke())
        } catch (e: Exception) {
            SimpleResponse.failure(e)
        }
    }
}