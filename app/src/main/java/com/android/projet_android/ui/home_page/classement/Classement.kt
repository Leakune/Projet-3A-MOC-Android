package com.android.projet_android.ui.home_page.classement

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.android.projet_android.R
import com.google.android.material.tabs.TabLayout


class Classement: Fragment() {
    lateinit var tabLayout: TabLayout
    lateinit var viewPager: ViewPager
    lateinit var mContext: Context
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.classement, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout.addTab(tabLayout.newTab().setText("Titres"))
        tabLayout.addTab(tabLayout.newTab().setText("Albums"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL       //??
        val adapter = SectionPageAdapter(mContext, childFragmentManager,
            tabLayout.tabCount)
        viewPager.adapter = adapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })

    }

}