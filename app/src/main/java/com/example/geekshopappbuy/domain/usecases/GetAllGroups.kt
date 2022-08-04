package com.example.geekshopappbuy.domain.usecases

import com.example.geekshopappbuy.domain.MainRepository
import com.example.geekshopappbuy.domain.entitys.GeekGroupUI
import com.example.geekshopappbuy.utils.ResourceVrap
import javax.inject.Inject

class GetAllGroups @Inject constructor(private val repository: MainRepository) {
    fun execute(): ResourceVrap<List<GeekGroupUI>>{
        return repository.getAllGroups()
    }
}