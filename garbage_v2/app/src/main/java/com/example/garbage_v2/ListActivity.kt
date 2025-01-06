package com.example.garbage_v2

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.garbage_v2.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() { //means that is extends the AppCompatActivity class

    private lateinit var binding: ActivityListBinding
    private lateinit var itemsToSortDB: ItemsToSortDB //declaring a variable of type ItemsToSortDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        itemsToSortDB = ItemsToSortDB.getInstance()

        val binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.AllItems.text = "All Items"

        val fab = binding.fab  // Reference the FAB from binding
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab)
                .show()
        }
    }
}