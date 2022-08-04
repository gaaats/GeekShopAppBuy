package com.example.geekshopappbuy.domain

import com.example.geekshopappbuy.data.entity.groups.ResultGroupSearch
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.domain.entitys.GeekProductUI
import com.example.geekshopappbuy.utils.ResourceVrap

interface MainRepository {

    fun getAllProductsByGroupId(groupId:Int):ResourceVrap<List<GeekProductUI>>
    fun getProductInfo(productId:Int)
    fun getAllGroups(): ResourceVrap<List<GeekGroupUI>>
//    fun getPaymentOptions()
//    fun getDeliveryOptions()
//    fun makeOrder()
//    fun getInfoAboutOrder()
}