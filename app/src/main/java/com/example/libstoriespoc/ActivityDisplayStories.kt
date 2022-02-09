package com.example.libstoriespoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.view.customviews.CustomStoriesActivity
import com.example.libstoriespoc.view.customviews.Story

class ActivityDisplayStories() : AppCompatActivity() {

    private var customStoriesActivity: CustomStoriesActivity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_stories)

        val storiesList = intent.getSerializableExtra("storiesList") as Story
        customStoriesActivity?.setupStories(storiesList)

    }
}