package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//entity is like table in a database
@Entity(tableName = "notes_table")
class Note(@ColumnInfo(name = "text") val text: String){
    @PrimaryKey(autoGenerate = true) var id = 0
}