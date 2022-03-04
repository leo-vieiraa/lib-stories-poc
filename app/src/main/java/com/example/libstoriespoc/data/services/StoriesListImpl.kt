package com.example.libstoriespoc.data.services

import com.example.libstoriespoc.domain.model.Story

interface StoriesListImpl {

    suspend fun getStories() : MutableList<Story>

    suspend fun setStory(story: Story)

}