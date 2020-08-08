package d4static.dev999.easynotes.viewmodels

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FieldValue
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.callback.OnServerResponseListener
import d4static.dev999.easynotes.manager.FireStoreManager
import d4static.dev999.easynotes.manager.PreferenceManager
import d4static.dev999.easynotes.model.ListItemModel
import d4static.dev999.easynotes.model.NoteFsModel
import d4static.dev999.easynotes.repository.NoteRepository
import d4static.dev999.easynotes.ui.main.NoteTable
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AddNoteViewModel @ViewModelInject constructor(private val noteRepository: NoteRepository) :
    BaseViewModel() {

    val TAG = "AddNoteViewModel"

    lateinit var mutableLiveData: MutableLiveData<ListItemModel>
    lateinit var onServerResponseListener: OnServerResponseListener

    override fun init(obj: Any) {
        super.init(obj)
        setDashboardItems()
    }

    fun setListener(listener: OnServerResponseListener) {
        this.onServerResponseListener = listener;
    }


    fun setDashboardItems() {
        var listItem = ListItemModel(
            1, "Title 1", "SubTitle 1", "","",
            false, "", Date(), Date()
        )

        mutableLiveData = MutableLiveData()
        mutableLiveData.value = listItem
    }



    fun setDataWithDocument(noteFsModel: NoteFsModel) {


        FireStoreManager.getNotesCollection().document(
            PreferenceManager.getPreference().getData(
                PreferenceManager.USER_ID, String, "user"
            ) as String
        )
            .update("data", FieldValue.arrayUnion(noteFsModel)).addOnSuccessListener {

            onServerResponseListener.onSuccessListener(null)
        }.addOnFailureListener {
                Log.v(TAG, it.message!!.toString())

        }
    }

    fun removeDataWithDocument(noteFsModel: NoteFsModel) {

        FireStoreManager.getNotesCollection().document("userNotes")
            .update("data", FieldValue.arrayRemove(noteFsModel)).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }

    /**
     * This will auto generate the document
     */
    fun addData(noteFsModels: ArrayList<NoteFsModel>) {

        FireStoreManager.getNotesCollection().add(noteFsModels).addOnSuccessListener {

        }.addOnFailureListener {

        }
    }

    fun updateNote(noteFsModels: NoteFsModel) {

        FireStoreManager.getNotesCollection().document("userNotes")
            .update("title", noteFsModels.title).addOnSuccessListener {

            }.addOnFailureListener {

            }
    }

    fun addToDatabase(noteFsModels: ArrayList<NoteFsModel>) {

        viewModelScope.launch(Dispatchers.IO) {
            for (model in noteFsModels) {
                var noteTable = NoteTable(0, model.title!!, model.body!!, 0, 1)
                noteRepository.insertNoteData(noteTable)
            }
        }

    }

}