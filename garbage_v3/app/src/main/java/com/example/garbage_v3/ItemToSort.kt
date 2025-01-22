package com.example.garbage_v3

data class ItemToSort(val what: String, val where: String) { //data tells kotlin to make a class with getters and setters
    fun oneLine(pre: String = "", post: String = " in "): String {
        return "$pre$what$post$where"
    }
    override fun toString(): String = oneLine("", " goes to ")
    }

