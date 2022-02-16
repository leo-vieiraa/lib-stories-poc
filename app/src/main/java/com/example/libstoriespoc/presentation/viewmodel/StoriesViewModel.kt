package com.example.libstoriespoc.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.libstoriespoc.data.repository.StoriesRepository
import com.example.libstoriespoc.domain.model.Story

class StoriesViewModel (val repository: StoriesRepository) : ViewModel() {

    val _checkStories = MutableLiveData<MutableList<Story>>()
    val checkStories : LiveData<MutableList<Story>> = _checkStories

    fun getStories() {
        _checkStories.value = repository.getStories()
    }

    fun setStories(story: Story) {
        repository.setStories(story)
    }

}