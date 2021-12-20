package com.example.scentit.DataModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.scentit.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShopDataSet{
    fun getBanner1Data(): LiveData<MutableList<ShopItem>> {
        val liveShops = MutableLiveData<MutableList<ShopItem>>()
        val database = FirebaseDatabase.getInstance()
        val ref = database.getReference("shop_banner1")
        ref.addValueEventListener(object : ValueEventListener {
            val mlist = mutableListOf<ShopItem>()
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for(ShopSnapshot in snapshot.children) {
                        val data = ShopSnapshot.getValue(ShopItem::class.java)  //읽어온 데이터로 오브젝트 생성
                        mlist.add(data!!)
//                        Log.i("Test","mlist : " + mlist.size)
//                        Log.i("Test","mlist : " + mlist)
                    }
                    liveShops.value = mlist  //라이브 데이터로 넣고 리턴
                }
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
        return liveShops
    }

    fun Shop2MakeSet() : List<ShopItem2>{
        return listOf<ShopItem2>(
            ShopItem2(R.drawable.perfume2,R.string.shop_banner1),
            ShopItem2(R.drawable.main_banner2,R.string.shop_banner2),
            ShopItem2(R.drawable.perfume3,R.string.shop_banner3),
            ShopItem2(R.drawable.perfume4,R.string.shop_banner4),
            ShopItem2(R.drawable.main_banner1,R.string.shop_banner5)
        )
    }
}