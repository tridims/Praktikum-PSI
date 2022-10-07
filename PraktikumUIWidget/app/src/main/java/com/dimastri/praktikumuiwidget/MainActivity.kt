package com.dimastri.praktikumuiwidget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textPlaceholder: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textPlaceholder = findViewById<TextView>(R.id.textview)
        textPlaceholder.text = "Aplikasi baru melewati OnCreate"
        Log.i("MainActivity", "onCreate()")
    }

    override fun onStart() {
        textPlaceholder.text = "Aplikasi baru melewati onStart"
        Log.i("MainActivity", "onStart()")
        super.onStart()
    }

    override fun onResume() {
        textPlaceholder.text = "Aplikasi baru melewati onResume"
        Log.i("MainActivity", "onResume()")
        super.onResume()
    }

    override fun onPause() {
        textPlaceholder.text = "Aplikasi telah melewati onPause"
        Log.i("MainActivity", "onPause()")
        super.onPause()
    }

    override fun onStop() {
        textPlaceholder.text = "Aplikasi sudah pernah melewati onStop"
        Log.i("MainActivity", "onStop()")
        super.onStop()
    }

    override fun onDestroy() {
        textPlaceholder.text = "Aplikasi telah melewati onDestroy"
        Log.i("MainActivity", "onDestroy()")
        super.onDestroy()
    }
}