package com.example.libstoriespoc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.R
import com.example.libstoriespoc.ui.customviews.CustomStoriesLayout
import com.example.libstoriespoc.domain.model.Story
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityDisplayStories() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_stories)

        val storiesList = intent.getSerializableExtra("storiesList") as List<Story>
        val storyPosition = intent.getIntExtra("storyPosition", 0)
//        possível futura implementacao
//        val itemView = intent.getSerializableExtra("itemView")
        findViewById<CustomStoriesLayout>(R.id.customStoriesActivity).setupStories(storiesList, storyPosition)

    }
}