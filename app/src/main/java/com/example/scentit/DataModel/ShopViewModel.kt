package com.example.scentit.DataModel

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopViewModel : ViewModel() {
    private val dataSource = ShopDataSet()
    fun getBanner() : LiveData<MutableList<ShopItem>> {
        val data = MutableLiveData<MutableList<ShopItem>>()
        dataSource.getBanner1Data().observeForever { //디비로부터 데이터를 가져와만든 오브젝트에 옵저버를 붙임. 변화를 감시하겠다.
            data.value = it
        }
        return data
    }
}