package com.d4static.easeme.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d4static.easeme.R
import com.d4static.easeme.listener.ItemListener
import kotlinx.android.synthetic.main.home_item.view.*

class HomeAdapter(items: List<String>, listener: ItemListener) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private val mItems = items;
    private val mListener = listener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {

        holder.textView.text = mItems.get(position)
        holder.textView.setOnClickListener { mListener.onClickItem(mItems.get(position)) }
    }

    class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.tvText

    }
}