package com.pall.doadzikirapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pall.doadzikirapp.R
import com.pall.doadzikirapp.model.DoaDzikirItem

// Adapter is a subclass from RecyclerView which take responsibility
// for providing views that represent/display items (layout item) in a data set (kumpulan data).
class DoaDzikirAdapter : RecyclerView.Adapter<DoaDzikirAdapter.DzikirViewHolder>() {

    private val listData = ArrayList<DoaDzikirItem>()

    // set data from data source to Adapter
    fun setData(list: List<DoaDzikirItem>) {
        listData.clear()
        listData.addAll(list)
    }

    // viewHolder take responsibility for initialize item from layout
    // in this class we will describes our view from layout
    inner class DzikirViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle = view.findViewById<TextView>(R.id.item_title)
        val itemArabic = view.findViewById<TextView>(R.id.item_arabic)
        val itemTranslete = view.findViewById<TextView>(R.id.item_translete)

    }

    // onCreateViewHolder provides layout to be used by ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= DzikirViewHolder(
            // LayoutInflater is a class to inflate a layout/view
            LayoutInflater.from(parent.context).inflate(R.layout.item_doa, parent, false)
        )

    // getItemCount is counting the size of data set will be display on RecyclerView
    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: DzikirViewHolder, position: Int) {
        val data = listData[position]
        holder.apply {
            itemTitle.text = listData[position].title
            itemArabic.text = listData[position].arabic
            itemTranslete.text = listData[position].translete


        }
    }

}