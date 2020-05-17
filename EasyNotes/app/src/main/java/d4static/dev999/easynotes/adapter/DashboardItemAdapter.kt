package d4static.dev999.easynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.callback.OnItemClickListener
import d4static.dev999.easynotes.databinding.DashboardListItemBinding
import d4static.dev999.easynotes.model.DashboardItem
import kotlinx.android.synthetic.main.dashboard_list_item.view.*

class DashboardItemAdapter(val onItemClickListener: OnItemClickListener) :
    RecyclerView.Adapter<DashboardItemAdapter.DashboardViewHolder>() {

    private lateinit var itemList: ArrayList<DashboardItem>
    private lateinit var binding: DashboardListItemBinding
    private lateinit var listener: OnItemClickListener;

    fun updateItem(list: ArrayList<DashboardItem>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.getContext()),
            R.layout.dashboard_list_item, parent, false
        );
        listener = onItemClickListener;
        return DashboardViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {

        holder.tvTitle.setText(itemList.get(position).name)
        holder.ivIcon.setImageResource(itemList.get(position).imageId)

        holder.itemView.setOnClickListener {
            listener.onItemClick(itemList.get(position), holder.itemView)
        }
    }


    class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tvTitle = itemView.tvTitle;
        var ivIcon = itemView.ivImage;


    }

}