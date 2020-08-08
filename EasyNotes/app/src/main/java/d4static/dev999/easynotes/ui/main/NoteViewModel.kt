package d4static.dev999.easynotes.ui.main

import androidx.lifecycle.ViewModel
import d4static.dev999.easynotes.dao.NoteDao

class NoteViewModel(private val dataSource: NoteDao) : ViewModel() {




    fun updateNote(noteTable: NoteTable) {
        return dataSource.insertNoteData(noteTable)
    }

    companion object {
        const val NOTE_ID = "1"
    }
}