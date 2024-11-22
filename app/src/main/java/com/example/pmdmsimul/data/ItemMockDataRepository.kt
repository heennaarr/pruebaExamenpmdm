package com.example.pmdmsimul.data

import com.example.pmdmsimul.domain.Item
import com.example.pmdmsimul.domain.ItemRepository
import org.koin.core.annotation.Single

@Single
class ItemMockDataRepository():ItemRepository{
    private val items = listOf(
        Item("1", "henar" ,"Tere", "herráez"),
        Item("2", "alfonso" , "Monica","suarez"),
        Item("3", "unai" , "Paula","gomez"),
    )
   override fun getItems() : List<Item>{
        return items
    }

    override fun getItemById(id:String): Item {
        return items.find{
            it.id==id
        }?: Item("null" , "null" ,"null", "")
    }
}