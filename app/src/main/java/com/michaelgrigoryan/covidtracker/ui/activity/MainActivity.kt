package com.michaelgrigoryan.covidtracker.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.michaelgrigoryan.covidtracker.R
import com.michaelgrigoryan.covidtracker.ui.fragment.MainFragment
import com.michaelgrigoryan.covidtracker.ui.fragment.SearchFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val home = MainFragment()
        val search = SearchFragment()
        val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, home)
            commit()
        }

        navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigate_home -> makeFragment(home)
                R.id.navigate_search -> makeFragment(search)
            }
            true
        }
    }

    private fun makeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            commit()
        }
    }
}
