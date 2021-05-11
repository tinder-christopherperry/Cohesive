package com.tinder.ui.core

import android.content.Context
import android.graphics.RectF
import android.util.AttributeSet
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.*
import kotlin.math.max
import kotlin.math.min

/**
 * Circular ImageView, used for displaying user avatars etc.
 */
class TinderCircleImageView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) :
    ShapeableImageView(context, attrs) {

    init {
        shapeAppearanceModel =
            ShapeAppearanceModel().toBuilder()
                .setBottomLeftCorner(CornerFamily.ROUNDED, ::halfWidth)
                .setBottomRightCorner(CornerFamily.ROUNDED, ::halfWidth)
                .setTopLeftCorner(CornerFamily.ROUNDED, ::halfWidth)
                .setTopRightCorner(CornerFamily.ROUNDED, ::halfWidth)
                .build()
    }

    // Force the smaller dimension to make sure we stay a circle despite
    // any developer mistake in XML etc.
    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val h = this.measuredHeight
        val w = this.measuredWidth
        var size = min(w, h)
        if (size == 0) size = max(w, h)
        setMeasuredDimension(size, size)
    }

    private fun halfWidth(bounds: RectF) : Float {
        return bounds.width() * 0.5f
    }
}