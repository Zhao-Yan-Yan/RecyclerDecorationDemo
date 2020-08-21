package com.yan.recyclerdecorationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.yan.recyclerdecorationdemo.adapter.CommonAdapter
import com.yan.recyclerdecorationdemo.decoration.LinearDecoration
import kotlinx.android.synthetic.main.activity_linear_decoration.*

class LinearDecorationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_decoration)
        rlv.addItemDecoration(LinearDecoration(includeTopItem = true, includeBottomItem = true, itemSpace = 20))
        rlv.layoutManager = LinearLayoutManager(this)
        rlv.itemAnimator = DefaultItemAnimator()
        rlv.adapter = CommonAdapter()
    }
}