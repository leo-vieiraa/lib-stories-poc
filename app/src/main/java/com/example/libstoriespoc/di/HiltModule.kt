package com.example.libstoriespoc.di

import com.example.libstoriespoc.data.services.StoriesListImpl
import com.example.libstoriespoc.data.services.StoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HiltModule {

    @Provides
    fun provideStoriesList() : StoriesListImpl = StoriesService

}