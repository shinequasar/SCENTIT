package com.example.scentit.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.scentit.MainActivity
import com.example.scentit.R

class MainAdapter(private val context: MainActivity, private val dataset: List<Int>)
    : RecyclerView.Adapter<MainAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        public var itemimage: ImageView = itemView.findViewById(R.id.main_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.main_item, parent, false)

        return MyViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemimage.setImageResource(item)
    }

    override fun getItemCount() = dataset.size
    }