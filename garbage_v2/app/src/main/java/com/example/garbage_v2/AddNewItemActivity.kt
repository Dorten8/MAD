package com.example.garbage_v2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AddNewItemActivity : AppCompatActivity() {

    private lateinit var itemsToSortDB: ItemsToSortDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_item)

        itemsToSortDB = ItemsToSortDB.getInstance()
        val notification = findViewById<TextView>(R.id.notification_item_added)
        notification.visibility = View.INVISIBLE


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


//        val addNewItemText = findViewById<TextView>(R.id.add_new_item_text)
//        val addNewItemWhereText = findViewById<TextView>(R.id.add_where_to_sort_new_item_text)
        val addNewItemButton = findViewById<Button>(R.id.add_new_item_button)


        addNewItemButton.setOnClickListener {
            val userInputWhatToSort = findViewById<TextView>(R.id.add_new_item_text).text.toString()
            val userInputWhereToSort = findViewById<TextView>(R.id.add_where_to_sort_new_item_text).text.toString()
            itemsToSortDB.addItem(userInputWhatToSort, userInputWhereToSort)
            notification.visibility = View.VISIBLE
            findViewById<TextView>(R.id.add_new_item_text).text = ""
            findViewById<TextView>(R.id.add_where_to_sort_new_item_text).text = ""
            val inputMethodManager = getSystemService(INPUT_METHOD_SERVICE) as android.view.inputmethod.InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(addNewItemButton.windowToken, 0)
        }
    }
}