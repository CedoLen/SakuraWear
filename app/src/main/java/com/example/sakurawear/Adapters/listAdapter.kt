package com.example.sakurawear.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.sakurawear.Network.feelings
import com.example.sakurawear.R

class listAdapter(val context: Context, val list: feelings):RecyclerView.Adapter<listAdapter.MyVH>() {
    class MyVH(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView = itemView.findViewById(R.id.image_adept)
        val textView: TextView=itemView.findViewById(R.id.text_adept)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val root =LayoutInflater.from(context).inflate(R.layout.item_adepter,parent,false)
        return MyVH(root)
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.textView.text = list.data[position].title
    }

    override fun getItemCount(): Int {
        return list.data.size
    }
}