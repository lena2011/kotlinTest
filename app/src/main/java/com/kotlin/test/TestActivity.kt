package com.kotlin.test

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.kotlin.test.adapter.RecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by Administrator on 2017/6/27.
 */
class TestActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }

    private fun init() {
//        val recyclerView: RecyclerView = find(R.id.recycler_view)
        forestList.layoutManager = LinearLayoutManager(this)
        doAsync() {
            val items = RequestForecastCommand("573").execute()
            uiThread {
                forestList.adapter = RecyclerAdapter(items){ toast(it.date)  }
            }
        }
    }
}