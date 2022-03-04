package com.example.libstoriespoc.data.services

import com.example.libstoriespoc.domain.model.Story

object StoriesService : StoriesListImpl {

    override suspend fun getStories(): MutableList<Story> = StoriesList.getStories()

    override suspend fun setStory(story: Story) {
        StoriesList.setStory(story)
    }
}