package com.example.kotlingridlayout

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CarAdapter(
    var carList: ArrayList<String>,
    var context: Context,
) : BaseAdapter() {

    override fun getCount(): Int {
        return carList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View = LayoutInflater.from(parent!!.context).inflate(
            R.layout.grid_tile,
            parent!!,
            false,
        )

        var carName : TextView = view.findViewById(R.id.textView)
        carName.text = carList[position]
        return view
    }
}