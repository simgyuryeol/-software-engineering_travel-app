package com.example.travel_preparelist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.Checkable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(val dataList: ArrayList<DataVo>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter.ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.checklist_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.prepare.text=dataList.get(position).prepare
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder (itemView : View): RecyclerView.ViewHolder(itemView){
        val prepare = itemView.findViewById<CheckBox>(R.id.checkBox)

    }
}