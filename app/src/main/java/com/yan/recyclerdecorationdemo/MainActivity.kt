package com.yan.recyclerdecorationdemo

import android.content.Intent
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


    }

    fun linearRlv(view: View) {
        start(LinearDecorationActivity::class.java)
    }

    fun gridRlv(view: View) {
        start(GridDecorationActivity::class.java)
    }

    fun special(view: View) {
        start(SpecialDecorationActivity::class.java)
    }

    fun start(cls:Class<*>){
        startActivity(Intent(this, cls))
    }
}