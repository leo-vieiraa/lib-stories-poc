package com.example.libstoriespoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.view.customviews.CustomStoriesActivity
import com.example.libstoriespoc.view.customviews.Story

class ActivityDisplayStories() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_stories)

        val storiesList = intent.getSerializableExtra("storiesList") as Story
        findViewById<CustomStoriesActivity>(R.id.customStoriesActivity).setupStories(storiesList)

    }
}