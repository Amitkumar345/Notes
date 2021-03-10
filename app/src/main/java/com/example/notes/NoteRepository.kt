package com.example.notes

import androidx.lifecycle.LiveData

class NoteRepository( private val noteDao: NoteDao) {
// Repository's task is to take out data
//    currently data is coming from a Dao "noteDao" (offline data) but can also take from any api(online) if we want
//    so our ViewModel will not have burden to see from where data is coming
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note){
        noteDao.insert(note)
    }

    suspend fun delete(note: Note){
        noteDao.delete(note)
    }
}
/* now we will make ViewModel {
         takes and manipulate data so activity don't have to worry about
         check activity if it is live or not, whether it is on screen or not - to make sure when to give data
         potrait -> landscape: activity destroys and again begin from onCreate method (data loss) {
                 helpful here. So ViewModel survives  configuration change
                 }
    }
*/
