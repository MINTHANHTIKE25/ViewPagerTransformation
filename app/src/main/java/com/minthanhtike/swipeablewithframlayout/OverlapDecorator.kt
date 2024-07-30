package com.minthanhtike.swipeablewithframlayout

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class OverlapDecorator(private val itemSpace: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val itemPosition = parent.getChildAdapterPosition(view)

        val rightOverlap = when (itemPosition) {
            1 -> 160
            2 -> 120
            3 -> 80
            4 -> 40
            else -> 200
        }
        val topOverlap = when (itemPosition){
            4 -> 0
            else -> 200
        }
        view.translationX = rightOverlap.toFloat() // Apply translation for right overlap
        outRect.set(
            0,
            -topOverlap,
            -rightOverlap,
            0
        ) // Adjust outRect to account for translation
//        val itemPosition = parent.getChildAdapterPosition(view)
//        when (itemPosition) {
//            0 -> outRect.set(-itemSpace, -itemSpace,0 , 0);
//            1 -> outRect.set(-itemSpace+ (-40), -itemSpace, 0, 0);
//            2 -> outRect.set(-itemSpace+ (-80), -itemSpace, 0, 0);
//            else -> outRect.set(0, -itemSpace,0, 0);
//        }
//        val width = view.layoutParams.width
//
//        val widthToShift = (overlapPercentage * width * -1) / 100
//
//        val position = parent.getChildAdapterPosition(view)
//
//        val isReversed = (parent.layoutManager as? LinearLayoutManager)?.reverseLayout ?: false
//
//        if (position == 0) {
//            return
//        } else {
//            if (isReversed) {
//                outRect.set(0, 0, widthToShift, 0)
//            } else {
//                outRect.set(widthToShift, -100, 0, 0)
//            }
//        }
    }
}