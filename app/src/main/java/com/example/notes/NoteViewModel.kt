package com.example.notes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
//    ViewModel's task is to take data from repository and provide to activity when called
    private val repository: NoteRepository
    val allNotes: LiveData<List<Note>>
    init{
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

//  this will talk to repository which has suspend delete function
    fun deleteNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
//        delete fun in repository is suspend (runs in background thread) so doing task under viewModelSope.    IO = Input/Output : telling type of operation
//        here all things will run under this CoroutineScope 'viewModelScope' runs in background thread
        repository.delete(note)
    }
    fun insertNote(note: Note) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }
}