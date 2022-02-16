package com.example.libstoriespoc.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.R
import com.example.libstoriespoc.data.services.StoriesList.Companion.storiesList
import com.example.libstoriespoc.presentation.viewmodel.StoriesViewModel
import com.example.libstoriespoc.ui.customviews.*
import org.koin.android.viewmodel.compat.ViewModelCompat.viewModel

class MainActivity : AppCompatActivity() {

    private var customRecyclerView: CustomRecyclerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customRecyclerView = findViewById(R.id.customRecyclerViewActivity)
        customRecyclerView?.init(storiesList, ActivityDisplayStories())
    }

}