package com.example.a2025_garbage_mad

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garbage_v1.ItemsToSortDB
import com.example.garbage_v1.R

class MainActivity : AppCompatActivity() {

    private lateinit var ItemsToSortDB: ItemsToSortDB // Respecting your naming

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbage_sorting) // Only set the layout once

        ItemsToSortDB = ItemsToSortDB() // Initialize after setting layout
        ItemsToSortDB.fillItemsDB()

        val listItemsButton = findViewById<Button>(R.id.list_button) // More descriptive name
        val itemsText = findViewById<TextView>(R.id.items) // Get the TextView reference

        listItemsButton.setOnClickListener {
            itemsText.setBackgroundColor(Color.WHITE) // Use Color.WHITE
            itemsText.text = "Garbage List: ${ItemsToSortDB.listItems()}" // String template, updated text
        }

        enableEdgeToEdge() // Keep this after setting the layout

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.items)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}