package com.example.cleanarchitecture.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.cleanarchitecture.data.daos.NumberTriviaDao
import com.example.cleanarchitecture.data.models.cache.NumberTriviaCache

@Database(entities = [NumberTriviaCache::class], version = 1)
abstract class NumberTriviaDatabase: RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "number_trivia_db"
    }

    abstract fun numberTriviaDao(): NumberTriviaDao
}