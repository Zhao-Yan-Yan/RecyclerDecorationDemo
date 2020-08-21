package com.yan.recyclerdecorationdemo.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yan.recyclerdecorationdemo.dp2px

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/21<p>
 */
class LinearDecoration(
    private val includeTopItem: Boolean,
    private val includeBottomItem: Boolean,
    private val itemSpace: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val realSpace = dp2px(itemSpace.toFloat())
        val position = parent.getChildAdapterPosition(view)
        val linearLayoutManager = parent.layoutManager as LinearLayoutManager
        val itemCount = linearLayoutManager.itemCount
        val isTopItem = position == 0
        val isBottomItem = (position + 1) == itemCount

        when {
            isTopItem -> {
                if (includeTopItem) {
                    outRect.set(0, realSpace, 0, realSpace / 2)
                } else {
                    outRect.set(0, 0, 0, realSpace / 2)
                }
            }
            isBottomItem -> {
                if (includeBottomItem) {
                    outRect.set(0, realSpace / 2, 0, realSpace)
                } else {
                    outRect.set(0, realSpace / 2, 0, 0)
                }
            }
            else -> {
                outRect.set(0, realSpace / 2, 0, realSpace / 2)
            }
        }
    }
}