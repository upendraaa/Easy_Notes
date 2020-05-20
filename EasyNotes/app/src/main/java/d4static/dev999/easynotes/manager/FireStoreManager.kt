package d4static.dev999.easynotes.manager

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FireStoreManager {

    private const val BASE_COLLECTION = "easynotes"
    private const val DOC_USER = "user"
    private const val COLLECTION_BANKS = "banks"
    private const val COLLECTION_NOTES = "notes"
    private lateinit var db: FirebaseFirestore


    fun getDB(): FirebaseFirestore {
        if (db == null)
            db = Firebase.firestore
        return db;
    }

    fun getUserDoc(): DocumentReference {
        return getDB().collection(BASE_COLLECTION).document(DOC_USER)
    }

    fun getBanksCollection(): CollectionReference {
        return getUserDoc().collection(COLLECTION_BANKS)
    }

    fun getNotesCollection(): CollectionReference {
        return getUserDoc().collection(COLLECTION_NOTES)
    }

}