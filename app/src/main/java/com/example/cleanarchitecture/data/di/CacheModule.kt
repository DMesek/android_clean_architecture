package com.example.cleanarchitecture.data.di

import android.content.Context
import androidx.room.Room
import com.example.cleanarchitecture.data.NumberTriviaDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideBlogDb(@ApplicationContext context: Context): NumberTriviaDatabase {
        return Room
            .databaseBuilder(
                context,
                NumberTriviaDatabase::class.java,
                NumberTriviaDatabase.DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }
}