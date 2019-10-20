package d4static.dev999.easynotes.ui.main

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NoteTable")
data class NoteTable(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "_id") var _id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "message") var message: String,
    @ColumnInfo(name = "updatedTime") var updatedTime: Int,
    @ColumnInfo(name = "status") var status: Int
) {



}