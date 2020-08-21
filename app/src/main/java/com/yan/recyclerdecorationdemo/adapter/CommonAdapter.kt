package com.yan.recyclerdecorationdemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yan.recyclerdecorationdemo.R

/**
 * <p>文件描述：<p>
 * <p>作者：admin (赵岩)<p>
 * <p>创建时间：2020/8/21<p>
 */
class CommonAdapter : RecyclerView.Adapter<CommonAdapter.Holder>() {

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))

    override fun getItemCount(): Int = 102

    override fun onBindViewHolder(holder: Holder, position: Int) {}
}