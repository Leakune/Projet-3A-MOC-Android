package com.android.projet_android.ui.home_page.classement

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2

@Suppress("DEPRECATION")
internal class SectionPageAdapter(
    var context: Context,
    fm: FragmentManager,
    var totalTabs: Int
): FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return totalTabs
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Titres()
            }
            1 -> {
                Albums()
            }
            else -> getItem(position)
        }
    }

}