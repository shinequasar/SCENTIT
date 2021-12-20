package com.example.scentit.DataModel

import com.example.scentit.R

class ShopDataSet{
    fun ShopMakeSet() : List<ShopItem>{
        return listOf<ShopItem>(
            ShopItem(R.drawable.main_banner1,R.string.app_name,R.string.app_name),
            ShopItem(R.drawable.main_banner2,R.string.app_name,R.string.app_name),
            ShopItem(R.drawable.main_banner1,R.string.app_name,R.string.app_name),
            ShopItem(R.drawable.main_banner1,R.string.app_name,R.string.app_name)
        )
    }

    fun Shop2MakeSet() : List<ShopItem2>{
        return listOf<ShopItem2>(
            ShopItem2(R.drawable.main_banner1,R.string.app_name),
            ShopItem2(R.drawable.main_banner2,R.string.app_name),
            ShopItem2(R.drawable.main_banner3,R.string.app_name),
            ShopItem2(R.drawable.main_banner1,R.string.app_name),
        )
    }
}