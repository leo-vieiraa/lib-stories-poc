package com.example.libstoriespoc.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.libstoriespoc.data.repository.StoriesRepository
import com.example.libstoriespoc.domain.model.Story
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StoriesViewModel @Inject constructor(
    private val repository: StoriesRepository) : ViewModel() {

    val _checkStories = MutableLiveData<List<Story>>()
    val checkStories : LiveData<List<Story>> = _checkStories

     fun getStories() {
        viewModelScope.launch {
            _checkStories.postValue(repository.getStories())
        }
    }

     fun setStories(story: Story) {
        viewModelScope.launch {
            repository.setStories(story)
        }
    }

}