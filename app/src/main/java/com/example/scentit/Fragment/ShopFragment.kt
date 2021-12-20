package com.example.scentit.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scentit.Adapter.ShopAdapter
import com.example.scentit.Adapter.ShopAdapter2
import com.example.scentit.DataModel.ShopDataSet
import com.example.scentit.MainActivity
import com.example.scentit.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShopFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurebabber()
        configurebabber2()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_shop, container, false)
    }



    private fun configurebabber(){ // recyclerview 데이터넣어주기
        val dataset = ShopDataSet().ShopMakeSet()
        viewManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        viewAdapter = ShopAdapter(MainActivity(), dataset)
        recyclerView = requireView().findViewById<RecyclerView>(R.id.shop_recyclerview1)
            .apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
    }

    private fun configurebabber2(){ //recyclerview 데이터넣어주기
        val dataset = ShopDataSet().Shop2MakeSet()
        viewManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        viewAdapter = ShopAdapter2(MainActivity(), dataset)
        recyclerView = requireView().findViewById<RecyclerView>(R.id.shop_recyclerview2)
            .apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ShopFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}