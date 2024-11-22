package com.example.pmdmsimul.domain

import org.koin.core.annotation.Single

@Single
class GetItemSelectedUseCase(private val itemRepository: ItemRepository){
    operator fun invoke(id:String) : Item{
        return itemRepository.getItemById(id)
    }
}