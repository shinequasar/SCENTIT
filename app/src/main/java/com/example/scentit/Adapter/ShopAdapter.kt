package com.example.scentit.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scentit.DataModel.ShopItem
import com.example.scentit.DataModel.ShopItem2
import com.example.scentit.MainActivity
import com.example.scentit.R

class ShopAdapter(private val context: Context, private val dataset: List<ShopItem>)
    : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {

    class ShopViewHolder(private val view : View) :RecyclerView.ViewHolder(view){
        var itemimage: ImageView = view.findViewById(R.id.item_image)
        var itemTitle: TextView = view.findViewById(R.id.item_name)
        var itemEx: TextView = view.findViewById(R.id.item_ex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ShopViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemimage.setImageResource(item.imgResource)
        holder.itemTitle.setText(item.strTitleResource)
        holder.itemEx.setText(item.strExResource)
    }

    override fun getItemCount() = dataset.size
}