package com.nezammohandesi.hamrehenazer.di

import com.edsab.pm.repository.ProjectDetailRepoImpl
import com.edsab.pm.repository.ProjectDocumentRepoImpl
import com.edsab.pm.repository.ProjectRepoImpl
import com.edsab.pm.repository.ProjectRepository
import com.edsab.pm.repository.ProjectVisitDocRepoImpl
import com.edsab.pm.repository.ProjectVisitRepoImpl
import com.nezammohandesi.hamrehenazer.data.dao.ProjectDao
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDetailRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectDocumentlRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectVisitDocRepository
import com.nezammohandesi.hamrehenazer.data.repositories.Interfaces.ProjectVisitRepository
import com.nezammohandesi.hamrehenazer.db.NazerDb
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideProjectDetailRepository(
        projectDao: ProjectDao, gson: Gson,
    ): ProjectDetailRepository {
        return ProjectDetailRepoImpl(
            projectDao,
            gson
        )
    }
    @Provides
    @Singleton
    fun provideProjectDocRepository(
        projectDao: ProjectDao, gson: Gson,
    ): ProjectDocumentlRepository {
        return ProjectDocumentRepoImpl(
            projectDao,
            gson
        )
    }

    @Provides
    @Singleton
    fun provideProjectVisitRepository(
        projectDao: ProjectDao, gson: Gson,
    ): ProjectVisitRepository {
        return ProjectVisitRepoImpl(
            projectDao,
            gson
        )
    }

    @Provides
    @Singleton
    fun provideProjectVisitDocRepository(
        projectDao: ProjectDao, gson: Gson,
    ): ProjectVisitDocRepository {
        return ProjectVisitDocRepoImpl(
            projectDao,
            gson
        )
    }

    @Provides
    @Singleton
    fun provideProjectRepository(
        projectDao: ProjectDao, gson: Gson,
    ): ProjectRepository {
        return ProjectRepoImpl(
            projectDao,
            gson
        )
    }
}