package d4static.dev999.easynotes.ui.main

import androidx.lifecycle.ViewModel
import io.reactivex.Completable
import io.reactivex.Flowable

class NoteViewModel(private val dataSource: NoteDao) : ViewModel() {


    fun getAllNotes(): Flowable<NoteTable> {
        return dataSource.getAllNotes();
    }

    fun getAllTitles(): Flowable<String> {
        return dataSource.getAllNotes().map { noteTable ->
            noteTable.title
        }
    }

    fun updateNote(noteTable: NoteTable): Completable {
        return dataSource.insertNoteData(noteTable)
    }

    companion object {
        const val NOTE_ID = "1"
    }
}