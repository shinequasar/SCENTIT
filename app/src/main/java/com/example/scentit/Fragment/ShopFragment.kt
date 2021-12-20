package com.example.scentit.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scentit.Adapter.ShopAdapter
import com.example.scentit.Adapter.ShopAdapter2
import com.example.scentit.DataModel.ShopDataSet
import com.example.scentit.DataModel.ShopViewModel
import com.example.scentit.MainActivity
import com.example.scentit.R

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class ShopFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var adapter: ShopAdapter
    private lateinit var viewModel: ShopViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        adapter = ShopAdapter(MainActivity())
        viewModel = ViewModelProvider(this).get(ShopViewModel::class.java)
        val recyclerView: RecyclerView = requireView().findViewById(R.id.shop_recyclerview1)
        recyclerView.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = adapter
        setData()
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

    fun setData() {
        activity?.let {
            viewModel.getBanner().observe(viewLifecycleOwner, Observer {  //옵저버기능 등록
                adapter.setShopList(it)  //데이터 넣어주기
                adapter.notifyDataSetChanged()
            })
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