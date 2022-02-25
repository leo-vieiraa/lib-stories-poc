package com.example.libstoriespoc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.R
import com.example.libstoriespoc.data.services.StoriesList.storiesList
import com.example.libstoriespoc.ui.customviews.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var customRecyclerView: CustomRecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customRecyclerView = findViewById(R.id.customRecyclerViewActivity)
        customRecyclerView?.init(ActivityDisplayStories())
    }

}