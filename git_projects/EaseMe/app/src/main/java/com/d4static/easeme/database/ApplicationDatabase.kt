package com.payoda.kotlindemo.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.d4static.easeme.database.Note
import com.d4static.easeme.database.NoteDao
import com.d4static.easeme.database.User
import com.d4static.easeme.database.UserDao

@Database(entities = arrayOf(User::class, Note::class), version = 1)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao
    abstract fun NoteDao(): NoteDao

}