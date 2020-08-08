package d4static.dev999.easynotes.repository

import d4static.dev999.easynotes.dao.NoteDao
import d4static.dev999.easynotes.ui.main.NoteTable
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun getAllNotes(): List<NoteTable> {
        return noteDao.getAllNotes();
    }

    suspend fun insertNoteData(noteTable: NoteTable) {
        return noteDao.insertNoteData(noteTable)
    }

    fun cleanTable() = noteDao.cleanTable();

}