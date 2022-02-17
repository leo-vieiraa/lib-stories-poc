package com.example.libstoriespoc.data.services

import com.example.libstoriespoc.domain.model.Story

object StoriesService : StoriesListImpl {

    override fun getStories(): MutableList<Story> = StoriesList.getStories()

    override fun setStory(story: Story) {

    }
}