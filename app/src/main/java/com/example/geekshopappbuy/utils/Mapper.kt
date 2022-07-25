package com.example.geekshopappbuy.utils

import com.example.geekshopappbuy.domain.entitys.GeekProductUI
import com.example.retrofitrequestsimpletest1.api.response.Product

object Mapper {

    fun mapFormPromModelToUi(promModel: Product): GeekProductUI {
        val listImages = promModel.images?.map {
            it?.url ?: throw RuntimeException("there is Uri inside Image item")
        } ?: throw RuntimeException("there is empty List<Images>")

        return GeekProductUI(
            id = promModel.id ?: throw RuntimeException("there is no id"),
            name = promModel.name ?: throw RuntimeException("there is no name"),
            price = promModel.price ?: throw RuntimeException("there is no price"),
            groupId = promModel.group?.id ?: throw RuntimeException("there is no groupId"),
            group_Name = promModel.group.name ?: throw RuntimeException("there is no group_Name"),
            category = promModel.category?.caption
                ?: throw RuntimeException("there is no category"),
            description = promModel.description
                ?: throw RuntimeException("there is no description"),
            mainImage = promModel.mainImage ?: throw RuntimeException("there is no description"),
            images = listImages
        )
    }
}