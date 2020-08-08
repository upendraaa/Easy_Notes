package d4static.dev999.easynotes.di

import android.content.Context
import androidx.room.Room
import d4static.dev999.easynotes.dao.NoteDao
import d4static.dev999.easynotes.ui.main.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java, "EasyNotes.db").build()
    }

    @Provides
    fun provideNoteDao(database: NoteDatabase): NoteDao = database.NoteDao()


}