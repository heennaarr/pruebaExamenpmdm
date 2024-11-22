package com.example.pmdmsimul.domain

import org.koin.core.annotation.Single

@Single
class GetItemsUseCase (private val itemRepository: ItemRepository) {
    operator fun invoke() : List<Item>{
        return itemRepository.getItems()
    }
}