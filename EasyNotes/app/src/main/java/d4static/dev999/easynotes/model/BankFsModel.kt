package d4static.dev999.easynotes.model

import com.google.firebase.Timestamp

data class BankFsModel(
    val bankName: String?, val accountNumber: String?, val ifscCode: String?, val password: String?,
    val secutityPin: String?, val createdDate: Timestamp?, val modifiedDate: Timestamp?
)