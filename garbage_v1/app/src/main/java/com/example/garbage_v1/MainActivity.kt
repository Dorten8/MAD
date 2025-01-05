package com.example.a2025_garbage_mad

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.garbage_v1.ItemsToSortDB
import com.example.garbage_v1.R

class MainActivity : AppCompatActivity() {

    private lateinit var itemsToSortDB: ItemsToSortDB // Respecting your naming

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.garbage_sorting) // Only set the layout once

        itemsToSortDB = ItemsToSortDB() // Initialize after setting layout
        itemsToSortDB.fillItemsDB()

        val listItemsButton = findViewById<Button>(R.id.where_to_sort_button) // Get the Button reference
        val itemsText = findViewById<TextView>(R.id.where_to_sort_result) // Get the TextView reference

        listItemsButton.setOnClickListener {
            val userInput = findViewById<EditText>(R.id.where_to_sort_input).text.toString()
//            itemsText.setBackgroundColor(Color.WHITE)
            itemsText.text = getString(R.string.sort_to, itemsToSortDB.whereToSortSearch(userInput)) // String template, updated text
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