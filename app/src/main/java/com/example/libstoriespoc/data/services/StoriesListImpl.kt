package com.example.libstoriespoc.data.services

import com.example.libstoriespoc.domain.model.Story

interface StoriesListImpl {

    fun getStories() : MutableList<Story>

    fun setStory(story: Story)

}