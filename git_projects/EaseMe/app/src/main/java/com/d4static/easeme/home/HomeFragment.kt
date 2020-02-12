package com.d4static.easeme.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.d4static.easeme.R
import com.d4static.easeme.listener.ItemListener
import com.d4static.easeme.util.Constants
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(), ItemListener {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel

    var adapter: HomeAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        adapter = HomeAdapter(Constants.features.toList(), this)
        recycleHome.adapter = adapter
        recycleHome.layoutManager = GridLayoutManager(context, 3)

    }

    override fun <T : Any> onClickItem(item: T) {


    }

}
