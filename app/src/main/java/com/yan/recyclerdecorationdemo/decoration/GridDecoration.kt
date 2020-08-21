package com.yan.recyclerdecorationdemo.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yan.recyclerdecorationdemo.dp2px

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/21<p>
 */
class GridDecoration(
    private val includeTop: Boolean = true,
    private val includeBottom: Boolean = true,
    private val includeLeft: Boolean = true,
    private val includeRight: Boolean = true,
    private val itemSpace: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val realSpace = dp2px(itemSpace.toFloat())
        val position = parent.getChildAdapterPosition(view)
        val gridLayoutManager = parent.layoutManager as GridLayoutManager
        val spanCount = gridLayoutManager.spanCount
        val itemCount = gridLayoutManager.itemCount
        val column = (position % spanCount) + 1
        val row = (position / spanCount) + 1
        val isLeftSlide = column == 1
        val isRightSlide = column == spanCount

        val rowCount = if (itemCount % spanCount != 0) {
            (itemCount / spanCount) + 1
        } else {
            itemCount / spanCount
        }

        val isTop = 1 == row
        val isBottom = rowCount == row

        when {
            isTop -> {
                when {
                    isLeftSlide -> {
                        val top: Int = if (includeTop) realSpace else 0
                        val left: Int = if (includeLeft) realSpace else 0
                        outRect.set(left, top, realSpace / 2, realSpace / 2)
                    }
                    isRightSlide -> {
                        val top: Int = if (includeTop) realSpace else 0
                        val right: Int = if (includeRight) realSpace else 0
                        outRect.set(realSpace / 2, top, right, realSpace / 2)
                    }
                    else -> {
                        val top: Int = if (includeTop) realSpace else 0
                        outRect.set(realSpace / 2, top, realSpace / 2, realSpace / 2)
                    }
                }
            }
            isBottom -> {
                when {
                    isLeftSlide -> {
                        val bottom: Int = if (includeBottom) realSpace else 0
                        val left: Int = if (includeLeft) realSpace else 0
                        outRect.set(left, realSpace / 2, realSpace / 2, bottom)
                    }
                    isRightSlide -> {
                        val bottom: Int = if (includeBottom) realSpace else 0
                        val right: Int = if (includeRight) realSpace else 0
                        outRect.set(realSpace / 2, realSpace / 2, right, bottom)
                    }
                    else -> {
                        val bottom: Int = if (includeBottom) realSpace else 0
                        outRect.set(realSpace / 2, realSpace / 2, realSpace / 2, bottom)
                    }
                }
            }
            else -> {
                when {
                    isLeftSlide -> {
                        val left: Int = if (includeLeft) realSpace else 0
                        outRect.set(left, realSpace / 2, realSpace / 2, realSpace / 2)
                    }
                    isRightSlide -> {
                        val right: Int = if (includeRight) realSpace else 0
                        outRect.set(realSpace / 2, realSpace / 2, right, realSpace / 2)
                    }
                    else -> {
                        outRect.set(realSpace / 2, realSpace / 2, realSpace / 2, realSpace / 2)
                    }
                }
            }
        }
    }
}