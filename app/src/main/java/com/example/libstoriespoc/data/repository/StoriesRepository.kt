package com.example.libstoriespoc.data.repository

import com.example.libstoriespoc.data.services.StoriesList
import com.example.libstoriespoc.data.services.StoriesListImpl
import com.example.libstoriespoc.data.services.StoriesService
import com.example.libstoriespoc.domain.model.Story
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class StoriesRepository @Inject constructor(private val storiesListImpl: StoriesListImpl) {

    suspend fun getStories(): MutableList<Story> = withContext(Dispatchers.IO) {
        return@withContext storiesListImpl.getStories()
    }


    suspend fun setStories(story: Story) {
        CoroutineScope(Dispatchers.IO).launch {
            storiesListImpl.setStory(story)
        }
    }

//    suspend fun setStories(story: Story) {
//        CoroutineScope(Dispatchers.IO).launch {
//            return@launch storiesListImpl.setStory(story)
//        }
//    }

}
