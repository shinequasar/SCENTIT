package com.example.scentit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.example.scentit.Adapter.MainAdapter
import com.example.scentit.Adapter.MainFragmentAdapter
import com.example.scentit.Adapter.ShopAdapter
import com.example.scentit.DataModel.DataSet
import com.example.scentit.DataModel.ShopDataSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureBottomNavigation()

    }

    private fun configureBottomNavigation(){ //nav에서 각 fagment연결
        main_frag_pager.adapter = MainFragmentAdapter(supportFragmentManager, 4)
        main_menu.setupWithViewPager(main_frag_pager)
        val bottomNaviLayout: View = this.layoutInflater.inflate(R.layout.activity_home_navtab, null, false)

        main_menu.getTabAt(0)!!.customView = bottomNaviLayout.findViewById(R.id.home_tab) as RelativeLayout
        main_menu.getTabAt(1)!!.customView = bottomNaviLayout.findViewById(R.id.shop_tab) as RelativeLayout
        main_menu.getTabAt(2)!!.customView = bottomNaviLayout.findViewById(R.id.info_tab) as RelativeLayout
        main_menu.getTabAt(3)!!.customView = bottomNaviLayout.findViewById(R.id.my_tab) as RelativeLayout
    }


}