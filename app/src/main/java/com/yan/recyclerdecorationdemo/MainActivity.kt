package com.yan.recyclerdecorationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rlv.itemAnimator = DefaultItemAnimator()
        //rlv.addItemDecoration(LinearDecoration(includeTopItem = true, includeBottomItem = true, itemSpace = 20))
        //rlv.layoutManager = LinearLayoutManager(this)

        //rlv.addItemDecoration(SpecialDecoration(this))
        //rlv.layoutManager = GridLayoutManager(this, 3)

        //rlv.layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
        //rlv.addItemDecoration(GridDecoration(includeTop = false, includeBottom = false, includeLeft = false, includeRight = false, itemSpace = 10))
        rlv.layoutManager = GridLayoutManager(this, 5)
        rlv.addItemDecoration(GridDecoration(includeTop = true, includeBottom = true, includeLeft = true, includeRight = true, itemSpace = 10))
        rlv.adapter = object : RecyclerView.Adapter<Holder>() {
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
                Holder(LayoutInflater.from(this@MainActivity).inflate(R.layout.item, parent, false))

            override fun getItemCount(): Int = 102

            override fun onBindViewHolder(holder: Holder, position: Int) {}
        }
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}