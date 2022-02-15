package com.example.libstoriespoc.view.customviews

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libstoriespoc.ActivityDisplayStories
import com.example.libstoriespoc.R
import com.example.libstoriespoc.adapter.UsersAdapter


class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {


    private lateinit var usersAdapter : UsersAdapter
    private lateinit var recycler : RecyclerView

    fun init(model:List<Story>, activity: Activity){
        inflate(context, R.layout.custom_recycler_view,this)
        recycler = findViewById(R.id.storiesRecyclerView)
        recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        usersAdapter = UsersAdapter(model,activity)
        recycler.adapter = usersAdapter


    }
  }