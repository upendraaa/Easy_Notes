package d4static.dev999.easynotes.viewmodels

import androidx.lifecycle.MutableLiveData
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.callback.OnServerResponseListener
import d4static.dev999.easynotes.manager.FireStoreManager
import d4static.dev999.easynotes.manager.PreferenceManager
import d4static.dev999.easynotes.model.ListItemModel
import d4static.dev999.easynotes.model.NoteFsModel
import java.util.*
import kotlin.collections.ArrayList

class NoteListViewModel : BaseViewModel() {

    lateinit var mutableLiveData: MutableLiveData<MutableList<ListItemModel>>
    lateinit var onServerResponseListener: OnServerResponseListener;

    override fun init(obj: Any) {
        super.init(obj)
        setDashboardItems()
    }

    fun setListener(listener: OnServerResponseListener) {
        this.onServerResponseListener = listener;
    }


    fun setDashboardItems() {
        var listItems = ArrayList<ListItemModel>()
        var listItem = ListItemModel(1, "Title 1", "SubTitle 1","",
            "", false, "", Date(), Date()
        )
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1","SubTitle 1", "","",
            false, "", Date(), Date()
        )
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1","",
            "", true, "", Date(), Date()
        )
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "","",
            true, "", Date(), Date()
        )
        listItems.add(listItem)
        listItem = ListItemModel(1, "Title 1", "SubTitle 1", "",
            "", false, "", Date(), Date()
        )
        listItems.add(listItem)

        mutableLiveData = MutableLiveData()
        mutableLiveData.value = listItems
    }

    fun getNotes(): ArrayList<NoteFsModel> {

        FireStoreManager.getNotesCollection().document(
            PreferenceManager.getPreference().getData(
                PreferenceManager.USER_ID, String, "user"
            ) as String
        ).get().addOnSuccessListener {

        }.addOnFailureListener {

        }

        return ArrayList();
    }

}