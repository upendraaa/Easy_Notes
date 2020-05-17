package d4static.dev999.easynotes.viewmodels

import androidx.lifecycle.MutableLiveData
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.model.ListItemModel

class NoteListViewModel : BaseViewModel() {

    lateinit var mutableLiveData: MutableLiveData<MutableList<ListItemModel>>

    override fun init(obj: Any) {
        super.init(obj)
        setDashboardItems()
    }


    fun setDashboardItems() {
        var listItems = ArrayList<ListItemModel>()
        var listItem = ListItemModel(1, "Title 1", "SubTitle 1", "", false, "")
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "", false, "")
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "", true, "")
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "", true, "")
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "", false, "")
        listItems.add(listItem)

        mutableLiveData = MutableLiveData()
        mutableLiveData.value = listItems
    }

}