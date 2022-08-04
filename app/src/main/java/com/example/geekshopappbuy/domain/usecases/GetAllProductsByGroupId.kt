package com.example.geekshopappbuy.domain.usecases

import com.example.geekshopappbuy.domain.MainRepository
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.domain.entitys.GeekProductUI
import com.example.geekshopappbuy.utils.ResourceVrap
import javax.inject.Inject

class GetAllProductsByGroupId @Inject constructor(private val repository: MainRepository) {
    fun execute (groupId:Int): ResourceVrap<List<GeekProductUI>>{
        return repository.getAllProductsByGroupId(groupId)
    }

}