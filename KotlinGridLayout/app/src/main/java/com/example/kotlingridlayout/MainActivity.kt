package com.example.kotlingridlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var gridView: GridView
   var nameList = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gridView = findViewById(R.id.gridView)
        getData()
        var adapter = CarAdapter(
            nameList,
            this@MainActivity,
        )
        gridView.adapter = adapter
        gridView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, "Selected car is: ${nameList[position]}", Toast.LENGTH_SHORT).show()
        }
    }

    fun getData(){
        nameList.addAll(
            listOf(
                "Aria",
                "BMW",
                "Lamborghini",
                "Ford",
                "Toyota",
                "Ferrari",
            )
        )
    }
}
// 5:35