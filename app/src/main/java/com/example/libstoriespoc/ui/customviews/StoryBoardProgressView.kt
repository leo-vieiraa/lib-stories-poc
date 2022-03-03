package com.example.libstoriespoc.ui.customviews

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.example.libstoriespoc.R
import java.util.ArrayList

class StoryBoardProgressView : LinearLayout {

    companion object {
        private val PROGRESS_BAR_LAYOUT_PARAM = LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f)
        private val SPACE_LAYOUT_PARAM = LayoutParams(5, LinearLayout.LayoutParams.WRAP_CONTENT)
    }

    private val progressBars = ArrayList<CustomPauseProgressBar>()
    private var storiesCount = -1
    /**
     * pointer of running animation
     */
    private var current = 0
    private var storiesListener: StoriesListener? = null
    internal var isReverse: Boolean = false
    internal var isComplete: Boolean = false

    interface StoriesListener {
        fun onNext()
        fun onPrev()
        fun onComplete()
    }

    @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(context: Context, attrs: AttributeSet?) {
        orientation = HORIZONTAL
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.StoryBoardProgressView)
        storiesCount = typedArray.getInt(R.styleable.StoryBoardProgressView_progressCount, 0)
        typedArray.recycle()
        bindViews()
    }

    private fun bindViews() {
        progressBars.clear()
        removeAllViews()

        for (i in 0 until storiesCount) {
            val p = createProgressBar()
            progressBars.add(p)
            addView(p)
            if (i + 1 < storiesCount) {
                addView(createSpace())
            }
        }
    }

    private fun createProgressBar(): CustomPauseProgressBar {
        return CustomPauseProgressBar(context).apply {
            layoutParams = PROGRESS_BAR_LAYOUT_PARAM
        }
    }

    private fun createSpace(): View {
        val v = View(context)
        v.layoutParams = SPACE_LAYOUT_PARAM
        return v
    }

    /**
     * Set story count and create views
     *
     * @param storiesCount story count
     */
    fun setStoriesCount(storiesCount: Int) {
        this.storiesCount = storiesCount
        bindViews()
    }

    /**
     * Set storiesListener
     *
     * @param storiesListener StoriesListener
     */
    fun setStoriesListener(storiesListener: StoriesListener) {
        this.storiesListener = storiesListener
    }

    /**
     * Skip current story
     */
    fun skip() {
        if (isComplete) return
        val p = progressBars[current]
        p.setMax()
    }

    /**
     * Reverse current story
     */
    fun reverse() {
        if (isComplete) return
        isReverse = true
        val p = progressBars[current]
        p.setMin()
    }

    /**
     * Set a story's duration
     *
     * @param duration millisecond
     */
    fun setStoryDuration(duration: Long) {
        for (i in progressBars.indices) {
            progressBars[i].setDuration(duration)
            progressBars[i].setCallback(callback(i))
        }
    }

    /**
     * Set stories count and each story duration
     *
     * @param durations milli
     */
    fun setStoriesCountWithDurations(durations: LongArray) {
        storiesCount = durations.size
        bindViews()
        for (i in progressBars.indices) {
            progressBars[i].setDuration(durations[i])
            progressBars[i].setCallback(callback(i))
        }
    }

    private fun callback(index: Int): CustomPauseProgressBar.Callback {
        return object : CustomPauseProgressBar.Callback {
            override fun onStartProgress() {
                current = index
            }

            override fun onFinishProgress() {
                if (isReverse) {
                    isReverse = false
                    if (storiesListener != null) storiesListener!!.onPrev()
                    if (0 <= current - 1) {
                        val p = progressBars[current - 1]
                        p.setMinWithoutCallback()
                        progressBars[--current].startProgress()
                    } else {
                        progressBars[current].startProgress()
                    }
                    return
                }
                val next = current + 1
                if (next <= progressBars.size - 1) {
                    if (storiesListener != null) storiesListener!!.onNext()
                    progressBars[next].startProgress()
                } else {
                    isComplete = true
                    if (storiesListener != null) storiesListener!!.onComplete()
                }
            }
        }
    }

    /**
     * Start progress animation
     */
    fun startStories(from: Int) {
        for (i in progressBars.indices) {
            progressBars[i].clear()
        }
        for (i in 0 until from) {
            if (progressBars.size > i) {
                progressBars[i].setMaxWithoutCallback()
            }
        }
        if (progressBars.size > from) {
            progressBars[from].startProgress()
        }
    }

    /**
     * Need to call when Activity or Fragment destroy
     */
    fun destroy() {
        for (p in progressBars) {
            p.clear()
        }
    }

    /**
     * Pause story
     */
    fun pause() {
        progressBars[current].pauseProgress()
    }

    /**
     * Resume story
     */
    fun resume() {
        progressBars[current].resumeProgress()
    }
}