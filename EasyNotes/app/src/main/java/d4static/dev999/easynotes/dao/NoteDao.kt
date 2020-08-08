package d4static.dev999.easynotes.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import d4static.dev999.easynotes.ui.main.NoteTable
import io.reactivex.Completable

@Dao
interface NoteDao {


    @Query("Select * from NoteTable")
    fun getAllNotes(): List<NoteTable>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoteData(noteTable: NoteTable): Completable;

    @Query("DELETE from NoteTable")
    fun cleanTable()


}