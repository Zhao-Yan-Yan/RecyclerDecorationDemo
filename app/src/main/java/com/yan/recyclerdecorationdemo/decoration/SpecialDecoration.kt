package com.yan.recyclerdecorationdemo.decoration

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yan.recyclerdecorationdemo.dp2px

class SpecialDecoration(val context: Context) : RecyclerView.ItemDecoration() {

    private val dividerPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        strokeWidth = 1f
        style = Paint.Style.STROKE
        color = Color.DKGRAY
    }
    private val horizontalLineWidth by lazy { dp2px(50f) }
    private val verticalLineHeight by lazy { dp2px(40f) }
    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        val gridLayoutManager = parent.layoutManager as GridLayoutManager
        val spanCount = gridLayoutManager.spanCount
        val childCount = parent.childCount
        for (i in 0 until childCount) {
            val childView = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(childView)
            val column = (position % spanCount) + 1
            val row = (position / spanCount) + 1
            val isLeftSlid = column == 1
            val isRightSlid = column == spanCount
            val isSlid = isLeftSlid || isRightSlid
            val isEvenRow = (row % 2) == 0
            val isOddRow = (row % 2) == 1
            val centerHorizontal = (childView.right.toFloat() + childView.left.toFloat()) / 2
            val centerVertical = (childView.top.toFloat() + childView.bottom.toFloat()) / 2
            val isHeaderLine = false
            val isFooterLine = false
            if (isOddRow) {
                if (isRightSlid) {
                    c.drawLine(
                        centerHorizontal,
                        childView.bottom.toFloat(),
                        centerHorizontal,
                        childView.bottom.toFloat() + verticalLineHeight,
                        dividerPaint
                    )
                } else {
                    c.drawLine(
                        childView.right.toFloat(),
                        centerVertical,
                        childView.right.toFloat() + horizontalLineWidth,
                        centerVertical,
                        dividerPaint
                    )
                }
            } else if (isEvenRow) {
                if (isLeftSlid) {
                    c.drawLine(
                        centerHorizontal,
                        childView.bottom.toFloat(),
                        centerHorizontal,
                        childView.bottom.toFloat() + verticalLineHeight,
                        dividerPaint
                    )
                } else {
                    c.drawLine(
                        childView.left.toFloat(),
                        centerVertical,
                        childView.left.toFloat() - horizontalLineWidth,
                        centerVertical,
                        dividerPaint
                    )
                }
            }
        }
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val gridLayoutManager = parent.layoutManager as GridLayoutManager
        val spanCount = gridLayoutManager.spanCount
        val childCount = parent.childCount
        val position = parent.getChildAdapterPosition(view)
        val column = (position % spanCount) + 1
        val row = (position / spanCount) + 1
        val isLeftSlid = column == 1
        val isRightSlid = column == spanCount
        val isSlid = isLeftSlid || isRightSlid
        val isEvenRow = (row % 2) == 0
        val isOddRow = (row % 2) == 1
        val centerHorizontal = (view.right.toFloat() + view.left.toFloat()) / 2
        val centerVertical = (view.top.toFloat() + view.bottom.toFloat()) / 2
        outRect.set(horizontalLineWidth / 2, 0, horizontalLineWidth / 2, verticalLineHeight)
    }
}