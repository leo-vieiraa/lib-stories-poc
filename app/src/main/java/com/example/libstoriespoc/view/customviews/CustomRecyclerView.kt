package com.example.libstoriespoc.view.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.libstoriespoc.R
import com.example.libstoriespoc.adapter.UsersAdapter


class CustomRecyclerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0,
) : ConstraintLayout(context, attrs, defStyleAttr) {


    private var usersAdapter : UsersAdapter? = null
    private var recycler : RecyclerView? = null

    fun init(list:List<String>){
        inflate(context, R.layout.custom_recycler_view,this)
        recycler = findViewById(R.id.storiesRecyclerView)
        recycler?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        usersAdapter = UsersAdapter(list)
        recycler?.adapter = usersAdapter
    }

    fun click() {
        usersAdapter?.click?.let {
            it()
        }
    }

}