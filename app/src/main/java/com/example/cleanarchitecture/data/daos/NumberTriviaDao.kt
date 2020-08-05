package com.example.cleanarchitecture.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cleanarchitecture.data.models.cache.NumberTriviaCache

@Dao
interface NumberTriviaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(triviaCache: NumberTriviaCache): Long

    @Query("SELECT * FROM number_trivia")
    suspend fun getAllTrivia(): List<NumberTriviaCache>

}