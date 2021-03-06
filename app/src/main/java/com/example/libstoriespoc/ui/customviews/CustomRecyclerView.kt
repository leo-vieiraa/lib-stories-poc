package com.example.libstoriespoc.ui.customviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libstoriespoc.R
import com.example.libstoriespoc.ui.adapter.UsersAdapter
import com.example.libstoriespoc.presentation.viewmodel.StoriesViewModel
import com.example.libstoriespoc.ui.ActivityDisplayStories


class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var usersAdapter : UsersAdapter
    private lateinit var recycler : RecyclerView
    private lateinit var viewModel: StoriesViewModel

    fun init(activity: Activity){
        inflate(context, R.layout.custom_recycler_view,this)

        setupRecyclerView(activity)
        viewModel.getStories()
    }

    fun setupRecyclerView(activity: Activity = ActivityDisplayStories()) {
        recycler = findViewById(R.id.storiesRecyclerView)
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        usersAdapter = UsersAdapter(activity)
        recycler.adapter = usersAdapter

        viewModel = ViewModelProvider(ViewTreeViewModelStoreOwner.get(this)!!).get(StoriesViewModel::class.java)
        viewModel.checkStories.observe(context as LifecycleOwner, Observer {
            usersAdapter.submitList(it)
        })
    }

  }