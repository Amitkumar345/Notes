package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {
//    Contains function implementation and query
    /* insert and delete are input/ouput function which takes time so we can't run it on
    main thread(otherwise it will make app laggy or not usuable during insertion or deletion)
    So, we should run these fun in background thread (by using suspend keyword and suspend function can only be called by other suspend fun or by Coroutines)  */

    // these annotation make fun to do desired task (here Insert). OnConflict means if note is already present in table
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query( "Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>  //Activity can know what and when is changing by making it LiveData (observes)
}
// Now we will make a databasa