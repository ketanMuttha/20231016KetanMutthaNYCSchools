package com.nyc.schools.presentation.di

import com.nyc.schools.constant.ApiConstant
import com.nyc.schools.data.remote.NycSchoolsAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(ApiConstant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideNycSchoolsAPIT(retrofit: Retrofit):NycSchoolsAPI{
        return retrofit.create(NycSchoolsAPI::class.java)
    }
}