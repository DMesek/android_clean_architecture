package com.example.cleanarchitecture.data.models.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "number_trivia")
class NumberTriviaCache(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "number")
    var number: Int,

    @ColumnInfo(name = "trivia")
    var trivia: String

)