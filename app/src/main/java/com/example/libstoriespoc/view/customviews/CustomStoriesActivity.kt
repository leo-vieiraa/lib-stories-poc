package com.example.libstoriespoc.view.customviews

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R

class CustomStoriesActivity @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null, @AttrRes
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), StoryBoardProgressView.StoriesListener {

    private var storyBoardProgressView: StoryBoardProgressView? = null
    private var counter = 0
    private val resources = intArrayOf(
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

    @SuppressLint("ClickableViewAccessibility")
    private val onTouchListener = View.OnTouchListener { v, event ->
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                pressTime = System.currentTimeMillis()
                storyBoardProgressView!!.pause()
                return@OnTouchListener false
            }
            MotionEvent.ACTION_UP -> {
                val now = System.currentTimeMillis()
                storyBoardProgressView!!.resume()
                return@OnTouchListener limit < now - pressTime
            }
        }
        false
    }

    fun setupStories() {

//        super.onCreate(savedInstanceState)
//
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(
//            WindowManager.LayoutParams.FLAG_FULLSCREEN,
//            WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main)

        Glide.with(context)
            .load("https://pbs.twimg.com/profile_images/699217734492647428/pCfEzr6L_400x400.png")
            .placeholder(R.drawable.ic_launcher_background)
            .into(findViewById(R.id.imageStories))
        storyBoardProgressView = findViewById<View>(R.id.storiesProgressView) as StoryBoardProgressView
        storyBoardProgressView!!.setStoriesCount(PROGRESS_COUNT)
        storyBoardProgressView!!.setStoryDuration(3000L)
        // or
        // storiesProgressView.setStoriesCountWithDurations(durations);
        storyBoardProgressView!!.setStoriesListener(this)
        storyBoardProgressView!!.startStories(counter)

        findViewById<ImageView>(R.id.imageStories)!!.setImageResource(resources[counter])

        // bind reverse view
        val reverse = findViewById<View>(R.id.reverse)
        reverse.setOnClickListener { storyBoardProgressView!!.reverse() }
        reverse.setOnTouchListener(onTouchListener)

        // bind skip view
        val skip = findViewById<View>(R.id.skip)
        skip.setOnClickListener { storyBoardProgressView!!.skip() }
        skip.setOnTouchListener(onTouchListener)

    }

//    public override fun onStop() {
//        super.onStop()
//    }

    override fun onNext() {
        findViewById<ImageView>(R.id.imageStories)!!.setImageResource(resources[++counter])
    }

    override fun onPrev() {
        if (counter - 1 < 0) return
        findViewById<ImageView>(R.id.imageStories)!!.setImageResource(resources[--counter])
    }

    override fun onComplete() {}
//    public override fun onDestroy() {
//        // Very important !
//        storyBoardProgressView!!.destroy()
//        super.onDestroy()
//    }

}
