package com.example.geekshopappbuy.domain.usecases

import com.example.geekshopappbuy.domain.MainRepository
import javax.inject.Inject

class GetProductInfo @Inject constructor(private val repository: MainRepository) {
}