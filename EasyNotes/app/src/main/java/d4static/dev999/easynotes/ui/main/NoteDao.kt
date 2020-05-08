package d4static.dev999.easynotes.ui.main

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface NoteDao {


    @Query("Select * from NoteTable")
    fun getAllNotes(): Flowable<NoteTable>;

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNoteData(noteTable: NoteTable): Completable;


}