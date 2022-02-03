package com.example.libstoriespoc.view.customviews.custom_views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.ScaleAnimation
import android.view.animation.Transformation
import android.widget.FrameLayout
import androidx.annotation.AttrRes
import com.example.libstoriespoc.R

internal class CustomPauseProgressBar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private val frontProgressView: View
    private val maxProgressView: View
    private var animation: PausableScaleAnimation? = null
    private var duration = DEFAULT_PROGRESS_DURATION.toLong()
    private var callback: Callback? = null

    internal interface Callback {
        fun onStartProgress()
        fun onFinishProgress()
    }
    init {
        LayoutInflater.from(context).inflate(R.layout.progress_pause, this)
        frontProgressView = findViewById(R.id.front_progress)
        maxProgressView = findViewById(R.id.max_progress) // work around
    }

    fun setDuration(duration: Long) {
        this.duration = duration
    }

    fun setCallback(callback: Callback) {
        this.callback = callback
    }

    fun setMax() {
        finishProgress(true)
    }
    fun setMin() {
        finishProgress(false)
    }
    fun setMinWithoutCallback() {
        maxProgressView.setBackgroundResource(R.color.progressbar_secondary)

        maxProgressView.visibility = View.VISIBLE
        if (animation != null) {
            animation!!.setAnimationListener(null)
            animation!!.cancel()
        }
    }
    private fun finishProgress(isMax: Boolean) {
        if (isMax) maxProgressView.setBackgroundResource(R.color.progressbar_max_active)
        maxProgressView.visibility = if (isMax) View.VISIBLE else View.GONE
        if (animation != null) {
            animation!!.setAnimationListener(null)
            animation!!.cancel()
            if (callback != null) {
                callback!!.onFinishProgress()
            }
        }
    }
    fun startProgress() {
        maxProgressView.visibility = View.GONE

        animation = PausableScaleAnimation(0f, 1f, 1f, 1f, Animation.ABSOLUTE, 0f, Animation.RELATIVE_TO_SELF, 0f)
        animation!!.duration = duration
        animation!!.interpolator = LinearInterpolator()
        animation!!.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {
                frontProgressView.visibility = View.VISIBLE
                if (callback != null) callback!!.onStartProgress()
            }

            override fun onAnimationRepeat(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                if (callback != null) callback!!.onFinishProgress()
            }
        })
        animation!!.fillAfter = true
        frontProgressView.startAnimation(animation)
    }

    fun pauseProgress() {
        if (animation != null) {
            animation!!.pause()
        }
    }

    fun resumeProgress() {
        if (animation != null) {
            animation!!.resume()
        }
    }

    fun clear() {
        if (animation != null) {
            animation!!.setAnimationListener(null)
            animation!!.cancel()
            animation = null
        }
    }

    private inner class PausableScaleAnimation internal constructor(fromX: Float, toX: Float, fromY: Float,
                                                                    toY: Float, pivotXType: Int, pivotXValue: Float, pivotYType: Int,
                                                                    pivotYValue: Float) : ScaleAnimation(fromX, toX, fromY, toY, pivotXType, pivotXValue, pivotYType, pivotYValue) {

        private var mElapsedAtPause: Long = 0
        private var mPaused = false

        override fun getTransformation(currentTime: Long, outTransformation: Transformation, scale: Float): Boolean {
            if (mPaused && mElapsedAtPause == 0L) {
                mElapsedAtPause = currentTime - startTime
            }
            if (mPaused) {
                startTime = currentTime - mElapsedAtPause
            }
            return super.getTransformation(currentTime, outTransformation, scale)
        }

        /***
         * pause animation
         */
        internal fun pause() {
            if (mPaused) return
            mElapsedAtPause = 0
            mPaused = true
        }

        /***
         * resume animation
         */
        internal fun resume() {
            mPaused = false
        }
    }

    companion object {

        /***
         * progress
         */
        private val DEFAULT_PROGRESS_DURATION = 2000
    }
}