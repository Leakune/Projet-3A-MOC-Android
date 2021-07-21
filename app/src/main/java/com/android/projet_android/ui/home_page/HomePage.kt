package com.android.projet_android.ui.home_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.android.projet_android.R
import kotlinx.android.synthetic.main.home_page.*

class HomePage: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_page, container, false)
    }
    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        // Assignez les valeurs à vos textes, images...
        super.onViewCreated(view, savedInstanceState)
        val navHost = childFragmentManager.findFragmentById(R.id.home_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(home_bottom_nav, navHost.navController)
    }
}
