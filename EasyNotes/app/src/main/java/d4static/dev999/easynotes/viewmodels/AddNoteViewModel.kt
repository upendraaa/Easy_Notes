package d4static.dev999.easynotes.viewmodels

import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.FieldValue
import d4static.dev999.easynotes.base.BaseViewModel
import d4static.dev999.easynotes.callback.OnServerResponseListener
import d4static.dev999.easynotes.manager.FireStoreManager
import d4static.dev999.easynotes.model.ListItemModel
import d4static.dev999.easynotes.model.NoteFsModel
import java.util.*

class AddNoteViewModel : BaseViewModel() {

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

        FireStoreManager.getNotesCollection().document("userNotes")
            .update("data", FieldValue.arrayUnion(noteFsModel)).addOnSuccessListener {

            onServerResponseListener.onSuccessListener(null)
        }.addOnFailureListener {

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

}