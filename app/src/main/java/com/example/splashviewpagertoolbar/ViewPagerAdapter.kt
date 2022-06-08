package com.example.splashviewpagertoolbar

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(
    fragment: FragmentActivity
): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                FirstPagerFragment()
            }
            1 -> {
                SecondPagerFragment()
            }
            else -> {
               ThirdPagerFragment()
            }
        }
    }
}
