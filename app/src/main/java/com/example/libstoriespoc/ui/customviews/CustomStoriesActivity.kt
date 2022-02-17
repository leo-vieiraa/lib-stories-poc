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
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R
import com.example.libstoriespoc.domain.model.Story
import com.example.libstoriespoc.presentation.viewmodel.StoriesViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CustomStoriesActivity @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), StoryBoardProgressView.StoriesListener {

    @Inject lateinit var storiesViewModel: StoriesViewModel

    private lateinit var storyBoardProgressView: StoryBoardProgressView

    private var counter = 0
    private val resourceList = intArrayOf(
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background,
        R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_background
    )

    //TODO: Analisar uso
    private val durations = longArrayOf(500L, 1000L, 1500L, 4000L)
    private var pressTime = 0L
    private var limit = 500L
    companion object {
        private const val PROGRESS_COUNT = 4
    }

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

    fun setupStories(storiesList: Story) {

        findViewById<ImageView>(R.id.imageStories).apply {
            Glide.with(this)
                .load(storiesList.media.x1)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }

        findViewById<ImageView>(R.id.imgProfile).apply {
            Glide.with(this)
                .load(storiesList.thumbnail.x1)
                .placeholder(R.drawable.ic_launcher_background)
                .into(this)
        }

        findViewById<TextView>(R.id.storiesTitle).text = storiesList.title

        storyBoardProgressView = findViewById<View>(R.id.storiesProgressView) as StoryBoardProgressView

        storyBoardProgressView.apply {
            setStoriesCount(resourceList.size)
            setStoryDuration(3000L)
            setStoriesListener(this@CustomStoriesActivity)
            startStories(counter)
        }

        // or
        // storiesProgressView.setStoriesCountWithDurations(durations);

        findViewById<ImageView>(R.id.imageStories)!!.setImageResource(resourceList[counter])

        // bind reverse view
        val reverse = findViewById<View>(R.id.reverse)

        reverse.apply {
            setOnClickListener { storyBoardProgressView.reverse() }
            setOnTouchListener(onTouchListener)
        }

        // bind skip view
        val skip = findViewById<View>(R.id.skip)
        skip.apply {
            setOnClickListener { storyBoardProgressView.skip() }
            setOnTouchListener(onTouchListener)
            storiesViewModel.setStories(storiesList)

        }
    }

    override fun onNext() {
        if (counter + 1 > resourceList.size) return
        findViewById<ImageView>(R.id.imageStories).setImageResource(resourceList[++counter])

    }

    override fun onPrev() {
        if (counter - 1 < 0) return
        findViewById<ImageView>(R.id.imageStories).setImageResource(resourceList[--counter])
    }

    override fun onComplete() {
        //storiesViewModel.setStories()



        //metodo para destruir

    }

//    public override fun onDestroy() {
//        // Very important !
//        storyBoardProgressView!!.destroy()
//        super.onDestroy()
//    }

}
