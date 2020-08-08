package d4static.dev999.easynotes.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import d4static.dev999.easynotes.dao.NoteDao

/**
 * Factory for ViewModels
 */
class ViewModelFactory(private val dataSource: NoteDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}