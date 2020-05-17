package d4static.dev999.easynotes.base

import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import d4static.dev999.easynotes.databinding.BaseListItemBinding
import d4static.dev999.easynotes.model.ListItemModel

open abstract class AppBaseAdapter(private val searchableList: MutableList<ListItemModel>) :
    RecyclerView.Adapter<AppBaseAdapter.BaseViewHolder>(), Filterable {


    open fun isEmpty(): Boolean {
        return !(searchableList == null || searchableList.size == 0)
    }

    private val originalList = ArrayList(searchableList)
    private var onNothingFound: (() -> Unit)? = null


    fun search(s: String?, onNothingFound: (() -> Unit)?) {
        this.onNothingFound = onNothingFound
        filter.filter(s)

    }

    override fun getFilter(): Filter {
        return object : Filter() {
            private val filterResults = FilterResults()
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                searchableList.clear()
                if (constraint.isNullOrBlank()) {
                    searchableList.addAll(originalList)
                } else {
                    val searchResults = originalList.filter { it.title.contains(constraint) }
                    searchableList.addAll(searchResults)
                }
                return filterResults.also {
                    it.values = searchableList
                }
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                // no need to use "results" filtered list provided by this method.
                if (searchableList.isNullOrEmpty())
                    onNothingFound?.invoke()
                notifyDataSetChanged()

            }
        }
    }

    class BaseViewHolder(binding: BaseListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        var binding: BaseListItemBinding? = binding

    }

}