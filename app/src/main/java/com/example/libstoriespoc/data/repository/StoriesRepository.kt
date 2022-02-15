package com.example.libstoriespoc.data.repository

import com.example.libstoriespoc.data.services.StoriesList
import com.example.libstoriespoc.domain.model.Story

class StoriesRepository (val storiesList: StoriesList) : StoriesRepositoryImpl{

    override fun getStories(): MutableList<Story> {
        return storiesList.storiesList()
    }

    override fun setStories(story: Story) {
        storiesList.setStory(story)
    }

}