package com.example.garbage_v2

class ItemsToSortDB private constructor(){ // Private constructor to prevent direct instantiation
    companion object { // Singleton pattern implementation
        @Volatile
        private var instance: ItemsToSortDB? = null // Volatile to make sure the instance is always up-to-date
        fun getInstance() = instance ?: synchronized(this) { //always gets the singleton instance of the class
            instance ?: ItemsToSortDB().also { instance = it }
        }
    }

    private val ItemsToSortDB = mutableListOf<ItemToSort>()//changed from var to val, the list if self can changed but the reference to it should not

    init { //special initializer block, makes sure the methods within the block are called when the class is instantiated
        fillItemsDB()
    }

    fun listItems(): String { //returns where do we sort based on item
        return ItemsToSortDB.joinToString("\n") { "sort to ${it.what} -> ${it.where}" }
    }//lambda -> an anonymous function that can be passed as an argument

    fun addItem (what: String, where: String) {
        synchronized(this) { //synchronized block to prevent concurrent modification of the list
            ItemsToSortDB.add(ItemToSort(what, where))
        }
    }
    fun getItem(what: String): String {
        return ItemsToSortDB.find { it.what == what }?.where ?: "not found"
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
        addItem("can", "metal")
        addItem("aluminum can", "metal")
        addItem("milk carton", "plastic")
    }
}