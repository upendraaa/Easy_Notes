package d4static.dev999.easynotes.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import d4static.dev999.easynotes.ui.main.NoteTable

@Dao
interface NoteDao {


    @Query("Select * from NoteTable")
    fun getAllNotes(): List<NoteTable>;

    @Insert
    fun insertNoteData(noteTable: NoteTable);

    @Query("DELETE from NoteTable")
    fun cleanTable()


}