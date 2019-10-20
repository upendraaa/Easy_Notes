package d4static.dev999.easynotes.ui.main

import android.content.Context

object Injection {

    fun provideUserDataSource(context: Context): NoteDao {
        val database = NoteDatabase.getInstance(context)
        return database.NoteDao()
    }

    fun provideViewModelFactory(context: Context): ViewModelFactory {
        val dataSource = provideUserDataSource(context)
        return ViewModelFactory(dataSource)
    }
}