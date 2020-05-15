package d4static.dev999.easynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.databinding.DashboardListItemBinding
import d4static.dev999.easynotes.model.DashboardItem

class DashboardItemAdapter : RecyclerView.Adapter<DashboardItemAdapter.DashboardViewHolder>() {

    lateinit var itemList: ArrayList<DashboardItem>
    lateinit var binding: DashboardListItemBinding

    fun updateItem(list: ArrayList<DashboardItem>) {
        this.itemList = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {

        binding = DashboardListItemBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.dashboard_list_item, parent)
        )

        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    class DashboardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}