package com.example.scentit.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.scentit.Fragment.HomeFragment
import com.example.scentit.Fragment.InfoFragment
import com.example.scentit.Fragment.MypageFragment
import com.example.scentit.Fragment.ShopFragment
import com.example.scentit.Fragment.*

class MainFragmentAdapter (fm : FragmentManager, val fragmentCount : Int) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> return HomeFragment()
            1 -> return ShopFragment()
            2 -> return InfoFragment()
            3 -> return MypageFragment()
            else -> return HomeFragment()
        }
    }
    override fun getCount(): Int = fragmentCount
}