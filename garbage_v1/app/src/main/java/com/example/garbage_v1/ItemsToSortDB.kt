package com.example.garbage_v1

class ItemsToSortDB {
    private var ItemsToSortDB = mutableListOf<ItemToSort>()

    init {
        fillItemsDB()
    }

    fun listItems(): String {
        return ItemsToSortDB.joinToString("\n") { "sort to ${it}" }
    }

    fun addItem (what: String, where: String) {
        ItemsToSortDB.add(ItemToSort(what, where))
    }

    fun fillItemsDB() {
        addItem("plastic bottle", "plastic")
        addItem("plastic bag", "plastic")
        addItem("plastic straw", "plastic")
        addItem("plastic cup", "plastic")
        addItem("plastic container", "plastic")
        addItem("plastic plate", "plastic")
        addItem("plastic cutlery", "plastic")
        addItem("plastic lid", "plastic")
        addItem("plastic wrap", "plastic")
        addItem("plastic packaging", "plastic")
        addItem("plastic toy", "plastic")
        addItem("plastic hanger", "plastic")
        addItem("plastic bucket", "plastic")
        addItem("plastic plant pot", "plastic")
        addItem("plastic bottle cap", "plastic")
        addItem("plastic bottle label", "plastic")
        addItem("plastic bottle pump", "plastic")
        addItem("plastic bottle seal", "plastic")
        addItem("plastic bottle shrink wrap", "plastic")
        addItem("plastic bottle sleeve", "plastic")
        addItem("plastic bottle spout", "plastic")
        addItem("plastic bottle trigger", "plastic")
        addItem("plastic bottle valve", "plastic")
        addItem("plastic bottle wrap", "plastic")
    }

}