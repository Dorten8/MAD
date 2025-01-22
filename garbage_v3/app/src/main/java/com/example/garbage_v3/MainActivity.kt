package com.example.a2025_garbage_mad

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garbage_v3.AddNewItemActivity
import com.example.garbage_v3.ItemsToSortDB
import com.example.garbage_v3.ListActivity
import com.example.garbage_v3.R

class MainActivity : AppCompatActivity() {

    private lateinit var itemsToSortDB: ItemsToSortDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbage_sorting) // Only set the layout once

//        itemsToSortDB = ItemsToSortDB() // Initialize after setting layout garbageV1
        itemsToSortDB = ItemsToSortDB.getInstance() // Initialize after setting layout garbageV2
        itemsToSortDB.fillItemsDB()
//  <main activity logic>
        val listItemsButton = findViewById<Button>(R.id.where_to_sort_button) // Get the Button reference
        val itemsText = findViewById<TextView>(R.id.where_to_sort_result) // Get the TextView reference

        listItemsButton.setOnClickListener {
            val userInput = findViewById<EditText>(R.id.where_to_sort_input).text.toString()
//            itemsText.setBackgroundColor(Color.WHITE)
            itemsText.text = getString(R.string.sort_to, itemsToSortDB.getItem(userInput)) // String template, updated text
        }
//  <add new item to the  list of items logic>
        val addNewItemButton = findViewById<Button>(R.id.add_new_item_button)

        addNewItemButton.setOnClickListener {
            val intent = Intent(this, AddNewItemActivity::class.java)
            startActivity(intent)
        }

//  <get to list of all items logic>
        val listAllItemsButton = findViewById<Button>(R.id.list_all_items_button)

//        listAllItemsButton.setOnClickListener {
//            itemsText.text = itemsToSortDB.listItems()
//        }
        listAllItemsButton.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }

        enableEdgeToEdge() // Keep this after setting the layout
        //Defines the padding of chosen @id, to be the same as the system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.heading_where_to_sort_it)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            val displayCutout = insets.getInsets(WindowInsetsCompat.Type.displayCutout())

            Log.d("Insets", "System bars: $systemBars, Display cutout: $displayCutout")

            v.setPadding(systemBars.left, systemBars.top + 30, systemBars.right, systemBars.bottom)
            insets
//            v.setPadding(systemBars.left, displayCutout.top, systemBars.right, systemBars.bottom)
//            insets
            // Does not work due to wrong definition by Pixel 9 emulator
        }
    }
}