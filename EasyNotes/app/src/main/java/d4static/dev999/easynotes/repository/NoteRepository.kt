package d4static.dev999.easynotes.repository

import d4static.dev999.easynotes.dao.NoteDao
import d4static.dev999.easynotes.ui.main.NoteTable
import io.reactivex.Completable
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun getAllNotes(): List<NoteTable> {
        return noteDao.getAllNotes();
    }

    fun insertNoteData(noteTable: NoteTable): Completable {
        return noteDao.insertNoteData(noteTable)
    }

    fun cleanTable() = noteDao.cleanTable();

}