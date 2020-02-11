package com.d4static.easeme.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {

    @Insert
    fun insertNote(vararg note: Note)

    @Query("Select title from note")
    fun getAllNotesTitle(): List<Note>

    @Query("Select * from note")
    fun getAllNotes(): List<Note>

    @Query("Select * from note where sentToNetwork = 1")
    fun getAllUnsentNotes(): List<Note>


}