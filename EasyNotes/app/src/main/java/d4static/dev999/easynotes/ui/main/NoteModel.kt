package d4static.dev999.easynotes.ui.main

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NoteModel(@PrimaryKey var id: Int, var title: String, var message: String) {}

