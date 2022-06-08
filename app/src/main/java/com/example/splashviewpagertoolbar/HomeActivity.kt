package com.example.splashviewpagertoolbar

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import com.example.splashviewpagertoolbar.databinding.ActivityHomeBinding
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarHome)

        binding.toolbarHome.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_reaction -> {
                    val intent = Intent(this, MoodActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.item_search -> {
                    true
                }
                else -> false
            }
        }
        setViewPager()
    }

    private fun setViewPager() {
        binding.viewPagerHome.adapter = ViewPagerAdapter(this)
        TabLayoutMediator(binding.tabLayoutHome, binding.viewPagerHome) { tab, position ->
            tab.text = getString(R.string.text_title_tab_view_pager).plus(" ${position.plus(1)}")
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}