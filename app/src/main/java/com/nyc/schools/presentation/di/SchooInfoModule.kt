package com.nyc.schools.presentation.di

import com.nyc.schools.data.remote.NycSchoolsAPI
import com.nyc.schools.data.repository.NycSchoolDetailsRepositoryImpl
import com.nyc.schools.data.repository.NycSchoolsRepositoryImpl
import com.nyc.schools.domain.repository.NycSchoolDetailsRepository
import com.nyc.schools.domain.repository.NycSchoolsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class SchoolInfoModule {
    @Provides
    fun providesNycSchoolsRepository(nycSchoolsAPI: NycSchoolsAPI) : NycSchoolsRepository {
        return NycSchoolsRepositoryImpl(nycSchoolsAPI)
    }

    @Provides
    fun providesNycSchoolDetailsRepository(nycSchoolsAPI: NycSchoolsAPI):NycSchoolDetailsRepository {
        return NycSchoolDetailsRepositoryImpl(nycSchoolsAPI)
    }
}