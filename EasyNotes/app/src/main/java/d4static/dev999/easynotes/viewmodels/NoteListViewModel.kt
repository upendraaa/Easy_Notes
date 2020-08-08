package d4static.dev999.easynotes.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.callback.OnServerResponseListener
import d4static.dev999.easynotes.manager.FireStoreManager
import d4static.dev999.easynotes.manager.PreferenceManager
import d4static.dev999.easynotes.model.ListItemModel
import d4static.dev999.easynotes.model.NoteFsModel
import d4static.dev999.easynotes.repository.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class NoteListViewModel @ViewModelInject constructor(private val noteRepository: NoteRepository) :
    BaseViewModel() {

    lateinit var mutableLiveData: MutableLiveData<MutableList<ListItemModel>>
    lateinit var onServerResponseListener: OnServerResponseListener;

    init {
        mutableLiveData = MutableLiveData()
        var listItems = ArrayList<ListItemModel>()

        viewModelScope.launch(Dispatchers.IO) {
            var listData = noteRepository.getAllNotes();
            for (data in listData) {
                var listItem = ListItemModel(
                    data._id, data.title, "SubTitle 1", data.message,
                    "", false, "", Date(), Date()
                )
                listItems.add(listItem)
            }
            mutableLiveData.postValue(listItems)
        }


    }

    override fun init(obj: Any) {
        super.init(obj)
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