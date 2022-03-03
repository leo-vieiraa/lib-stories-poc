package com.example.libstoriespoc.ui.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.AttrRes
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewTreeViewModelStoreOwner
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R
import com.example.libstoriespoc.domain.model.Story
import com.example.libstoriespoc.presentation.viewmodel.StoriesViewModel
import com.example.libstoriespoc.ui.ActivityDisplayStories

class CustomStoriesLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), StoryBoardProgressView.StoriesListener {

    private val storiesViewModel by lazy {
        ViewModelProvider(ViewTreeViewModelStoreOwner.get(this)!!).get(StoriesViewModel::class.java)
    }

    private lateinit var storyBoardProgressView: StoryBoardProgressView
    private lateinit var storiesList: List<Story>
    private var counter = 0
    private var pressTime = 0L
    private var limit = 500L

    init {
        inflate(context, R.layout.activity_custom_stories, this)
    }

    @SuppressLint("ClickableViewAccessibility")
    private val onTouchListener = View.OnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                pressTime = System.currentTimeMillis()
                storyBoardProgressView.pause()
                return@OnTouchListener false
            }
            MotionEvent.ACTION_UP -> {
                val now = System.currentTimeMillis()
                storyBoardProgressView.resume()
                return@OnTouchListener limit < now - pressTime
            }
        }
        false
    }

    fun setupStories(storiesList: List<Story>, currentItem: Int) {

        val currentStories = storiesList[currentItem]
        this.storiesList   = storiesList
        counter = currentItem

        findViewById<ImageView>(R.id.imageStories).apply {
            Glide.with(this)
                .load(currentStories.media.x1)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }

        findViewById<ImageView>(R.id.imgProfile).apply {
            Glide.with(this)
                .load(currentStories.thumbnail.x1)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }

        findViewById<TextView>(R.id.storiesTitle).apply{
            text = currentStories.title
        }

        findViewById<ImageView>(R.id.buttonClose).setOnClickListener {
           // getActivity(context)?.finish()
        }

        storyBoardProgressView = findViewById<View>(R.id.storiesProgressView) as StoryBoardProgressView

        storyBoardProgressView.apply {
            setStoriesCount(storiesList.size)
            setStoryDuration(3000L)
            setStoriesListener(this@CustomStoriesLayout)
            startStories(counter)
        }

        // bind reverse view
        findViewById<View>(R.id.reverse).apply {
            setOnClickListener { storyBoardProgressView.reverse() }
            setOnTouchListener(onTouchListener)
        }

        // bind skip view
        findViewById<View>(R.id.skip).apply {
            setOnClickListener { storyBoardProgressView.skip() }
            setOnTouchListener(onTouchListener)
            storiesViewModel.setStories(currentStories)
        }
    }

    override fun onNext() {
        if (counter + 1 > this.storiesList.size) return
        else return setupStories(storiesList, ++counter)
    }

    override fun onPrev() {
        if (counter - 1 < 0) return
        else return setupStories(storiesList, --counter)
    }

    override fun onComplete() {
        (context as ActivityDisplayStories).finish()
    }

//    public override fun onDestroy() {
//        // Very important !
//        storyBoardProgressView!!.destroy()
//        super.onDestroy()
//    }

}
