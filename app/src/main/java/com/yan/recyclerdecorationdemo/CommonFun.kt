package com.yan.recyclerdecorationdemo

import android.content.res.Resources

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/21<p>
 */


private val density = Resources.getSystem().displayMetrics.density

fun dp2px(dpValue: Float): Int = (0.5f + dpValue * density).toInt()

fun px2dp(pxValue: Float): Int = (pxValue / density).toInt()