package com.example.libstoriespoc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.libstoriespoc.adapter.UsersAdapter
import com.example.libstoriespoc.view.customviews.custom_views.CustomRecyclerView

class MainActivity : AppCompatActivity() {

    var customRecyclerView : CustomRecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        customRecyclerView = findViewById(R.id.storiesBar)

        customRecyclerView?.apply {
            click()
        }
    }
}