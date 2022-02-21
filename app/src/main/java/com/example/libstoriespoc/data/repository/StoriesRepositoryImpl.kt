package com.example.libstoriespoc.data.repository

import com.example.libstoriespoc.domain.model.Story

interface StoriesRepositoryImpl {

    fun getStories() : MutableList<Story>

    fun setStories(story: Story)

}