package com.example.pmdmsimul.domain

interface ItemRepository {
    fun getItems(): List<Item>
    fun getItemById(id:String): Item
}