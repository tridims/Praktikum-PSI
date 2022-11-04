package com.dimastri.psirecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.dimastri.psirecyclerview.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
    val mainFragment = FragmentMain()
    val secondaryFragment = FragmentSecondary()

    setActiveFragment(mainFragment)

    bottomNavigationView.setOnItemSelectedListener {
      when (it.itemId) {
        R.id.home -> setActiveFragment(mainFragment)
        R.id.menu -> setActiveFragment(secondaryFragment)
      }
      true
    }

    bottomNavigationView.setOnLongClickListener {
      Toast.makeText(this, "You clicked it long enough", Toast.LENGTH_SHORT).show()
      true
    }
  }

  fun setActiveFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
      replace(R.id.fragment, fragment)
      commit()
    }
  }
}