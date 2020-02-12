package com.d4static.easeme

import androidx.lifecycle.MutableLiveData
import com.d4static.easeme.base.BaseViewModel
import com.d4static.easeme.database.Note
import com.payoda.kotlindemo.database.ApplicationDatabase

class NotesViewModel(val database: ApplicationDatabase) : BaseViewModel() {

    private val mDatabase = database
    var noteListData = MutableLiveData<List<Note>>()

    fun saveNotes(note: Note) {
        mDatabase.NoteDao().insertNote(note)
    }

    fun getAllNotes() {
        noteListData.value = mDatabase.NoteDao().getAllNotes()
    }

}
