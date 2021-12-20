package com.example.scentit.Adapter

import android.content.Context
import android.graphics.Movie
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.scentit.DataModel.ShopItem
import com.example.scentit.DataModel.ShopItem2
import com.example.scentit.Fragment.ShopFragment
import com.example.scentit.MainActivity
import com.example.scentit.R
import kotlinx.android.synthetic.main.fragment_info_one.view.*

class ShopAdapter(private val context: Context)
    : RecyclerView.Adapter<ShopAdapter.ShopViewHolder>() {
    private var mlist: MutableList<ShopItem> = mutableListOf()

    class ShopViewHolder(view : View) :RecyclerView.ViewHolder(view){
        var itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.item_name)
        val itemEx: TextView = view.findViewById(R.id.item_ex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val cardView = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ShopViewHolder(cardView)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val bannerItem = mlist[position]
        holder.itemTitle.text = bannerItem.bannerTitle
        holder.itemEx.text = bannerItem.bannerEx
//        Log.i("Test","bannerItem : " + bannerItem.bannerTitle + " " + bannerItem.bannerEx)
    }

    override fun getItemCount() = mlist.size

    fun setShopList(data: MutableList<ShopItem>) {
        mlist = data
    }
}