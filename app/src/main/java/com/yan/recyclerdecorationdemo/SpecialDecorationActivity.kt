package com.yan.recyclerdecorationdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.yan.recyclerdecorationdemo.adapter.CommonAdapter
import com.yan.recyclerdecorationdemo.decoration.LinearDecoration
import com.yan.recyclerdecorationdemo.decoration.SpecialDecoration
import kotlinx.android.synthetic.main.activity_linear_decoration.*

class SpecialDecorationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_special_decoration)
        rlv.addItemDecoration(SpecialDecoration(this))
        rlv.layoutManager = GridLayoutManager(this, 3)
        rlv.itemAnimator = DefaultItemAnimator()
        rlv.adapter = CommonAdapter()
    }
}