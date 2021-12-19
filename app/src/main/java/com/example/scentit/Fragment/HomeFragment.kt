package com.example.scentit.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.scentit.Adapter.MainAdapter
import com.example.scentit.DataModel.DataSet
import com.example.scentit.MainActivity
import com.example.scentit.R
import kotlinx.android.synthetic.main.fragment_main_home.*



class HomeFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configurebabber()
    }
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_main_home, container, false)
        }

    private fun configurebabber(){ //메인 recyclerview 데이터넣어주기
        val dataset = DataSet().makeSet()
        viewManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        viewAdapter = MainAdapter(MainActivity(), dataset)
        recyclerView = requireView().findViewById<RecyclerView>(R.id.main_recyclerview)
            .apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter
            }
    }
    }
