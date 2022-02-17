package com.example.libstoriespoc.data.repository

import com.example.libstoriespoc.data.services.StoriesList.storiesList
import com.example.libstoriespoc.data.services.StoriesListImpl
import com.example.libstoriespoc.domain.model.Story
import javax.inject.Inject

class StoriesRepository @Inject constructor (private val storiesListImpl: StoriesListImpl){

    fun getStories(): MutableList<Story> {
        return storiesListImpl.getStories()
    }

    fun setStories(story: Story) {
        storiesListImpl.setStory(story)
    }

}