package com.example.tinderclone.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.tinderclone.R
import com.lorentzos.flingswipe.SwipeFlingAdapterView

class MainActivity : AppCompatActivity() {
    private var al = ArrayList<String>()
    private var arrayAdapter: ArrayAdapter<String>? = null
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        al.add("Python")
        al.add("ScikitLearn")
        al.add("Numpy")
        al.add("Pandas")
        al.add("Seaborn")
        al.add("Matplotlib")
        al.add("Kivy")
        al.add("Flask")

        arrayAdapter = ArrayAdapter(this, R.layout.item, R.id.helloText, al)

        val frameContainer = findViewById<View>(R.id.frame) as SwipeFlingAdapterView

        frameContainer.adapter = arrayAdapter
        frameContainer.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun removeFirstObjectInAdapter() {
                Log.d("LIST", "removed object!")
                al.removeAt(0)
                arrayAdapter?.notifyDataSetChanged()
            }

            override fun onLeftCardExit(p0: Any?) {
                Toast.makeText(this@MainActivity, "LEFT!", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(p0: Any?) {
                Toast.makeText(this@MainActivity, "RIGHT!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(p0: Int) {
                al.add("FrameWork $i")
                arrayAdapter?.notifyDataSetChanged()
                Log.d("LIST", "notified")
                i++
            }

            override fun onScroll(p0: Float) {
            }

        })
    }
    companion object{
        fun newIntent(context: Context?) = Intent(context, MainActivity::class.java)
    }
}