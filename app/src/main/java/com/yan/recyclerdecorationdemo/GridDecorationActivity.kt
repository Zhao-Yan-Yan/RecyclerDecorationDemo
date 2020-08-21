package com.yan.recyclerdecorationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yan.recyclerdecorationdemo.adapter.CommonAdapter
import com.yan.recyclerdecorationdemo.decoration.GridDecoration
import com.yan.recyclerdecorationdemo.decoration.LinearDecoration
import kotlinx.android.synthetic.main.activity_linear_decoration.*

class GridDecorationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_decoration)
        rlv.layoutManager = GridLayoutManager(this, 5)

        rlv.addItemDecoration(GridDecoration(includeTop = true, includeBottom = true, includeLeft = true, includeRight = true, itemSpace = 10))
        rlv.itemAnimator = DefaultItemAnimator()
        rlv.adapter = CommonAdapter()
    }
}