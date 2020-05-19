package d4static.dev999.easynotes.manager

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

object FireStoreManager {


  fun getDB(): FirebaseFirestore{
      val db = Firebase.firestore
    return db;
  }

}