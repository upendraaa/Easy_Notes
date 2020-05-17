package d4static.dev999.easynotes.viewmodels

import androidx.lifecycle.MutableLiveData
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.model.ListItemModel
import java.util.*

class AddBankViewModel : BaseViewModel() {

    lateinit var mutableLiveData: MutableLiveData<ListItemModel>

    override fun init(obj: Any) {
        super.init(obj)
        setDashboardItems()
    }


    fun setDashboardItems() {
        var listItem = ListItemModel(
            1, "Title 1",
            "SubTitle 1", "", false, "", Date()
        )

        mutableLiveData = MutableLiveData()
        mutableLiveData.value = listItem
    }

}