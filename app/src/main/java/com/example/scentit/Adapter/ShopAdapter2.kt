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

class ShopAdapter2(private val context: Context, private val dataset: List<ShopItem2>)
    : RecyclerView.Adapter<ShopAdapter2.ShopViewHolder>() {

    class ShopViewHolder(private val view : View) :RecyclerView.ViewHolder(view){
        var itemimage: ImageView = view.findViewById(R.id.shop_item2_image)
        var itemTitle: TextView = view.findViewById(R.id.shop_item2_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopAdapter2.ShopViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product2_item, parent, false)
        return ShopAdapter2.ShopViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = dataset[position]
        holder.itemimage.setImageResource(item.imgResource)
        holder.itemTitle.setText(item.strTitleResource)
    }

    override fun getItemCount() = dataset.size
}