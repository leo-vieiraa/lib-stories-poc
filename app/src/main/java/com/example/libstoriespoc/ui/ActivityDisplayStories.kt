package com.example.libstoriespoc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.R
import com.example.libstoriespoc.ui.customviews.CustomStoriesActivity
import com.example.libstoriespoc.domain.model.Story
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityDisplayStories() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_stories)

        val storiesList = intent.getSerializableExtra("storiesList") as Story
        findViewById<CustomStoriesActivity>(R.id.customStoriesActivity).setupStories(storiesList)

    }
}