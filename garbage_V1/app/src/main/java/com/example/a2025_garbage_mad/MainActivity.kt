package com.example.a2025_garbage_mad

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private ItemsToSortDB ItemsToSortDB;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // call the super class onCreate, making sure it will load what it is supposed to load
        setContentView(R.layout.garbage_sorting) // made a new layout

        ItemsToSortDB = new ItemsToSortDB(); //initilizing the database
        ItemsToSortDB.fillItemsDB(); //filling the database with items

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }
    }
}