package com.nezammohandesi.hamrehenazer.di

import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao
import com.nezammohandesi.hamrehenazer.db.NazerDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {
    @Provides
    @Singleton
    fun providesProjectDao(nazerDb: NazerDb): ProjectDao = nazerDb.ProjectDao()
}