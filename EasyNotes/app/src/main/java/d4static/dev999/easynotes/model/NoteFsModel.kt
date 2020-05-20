package d4static.dev999.easynotes.model

import com.google.firebase.Timestamp

data class NoteFsModel(
    val title: String?, val subTitle: String?, val body: String?,
    val createdDate: Timestamp, val modifiedDate: Timestamp
)