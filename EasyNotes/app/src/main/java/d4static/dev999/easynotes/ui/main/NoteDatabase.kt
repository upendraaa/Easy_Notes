package d4static.dev999.easynotes.ui.main

import androidx.room.Database
import androidx.room.RoomDatabase
import d4static.dev999.easynotes.dao.NoteDao

@Database(entities = arrayOf(NoteTable::class), version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun NoteDao(): NoteDao
}