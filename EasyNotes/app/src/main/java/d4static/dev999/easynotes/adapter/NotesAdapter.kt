package d4static.dev999.easynotes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import d4static.dev999.easynotes.R
import d4static.dev999.easynotes.base.AppBaseAdapter
import d4static.dev999.easynotes.callback.OnItemClickListener
import d4static.dev999.easynotes.databinding.BaseListItemBinding
import d4static.dev999.easynotes.model.ListItemModel

class NotesAdapter(
    val itemList: MutableList<ListItemModel>,
    val onItemClickListener: OnItemClickListener
) : AppBaseAdapter(itemList) {

    private lateinit var binding: BaseListItemBinding;
    private lateinit var listener: OnItemClickListener;

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.base_list_item,
            parent, false
        )
        this.listener = onItemClickListener
        return BaseViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return itemList.count()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.binding!!.input = itemList.get(position)
        holder.binding!!.root.setOnClickListener {
            listener.onItemClick(itemList.get(position), holder.itemView)
        }
    }


}

