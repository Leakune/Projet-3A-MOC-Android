package com.android.projet_android.ui.home_page

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.android.projet_android.R
import com.android.projet_android.databinding.ActivityMainBinding
import com.android.projet_android.ui.details.Titre
import kotlinx.android.synthetic.main.classement.*
import kotlinx.android.synthetic.main.home_page.*

class Classement: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.classement, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Assignez les valeurs à vos textes, images...
        super.onViewCreated(view, savedInstanceState)

        /*val navHost = childFragmentManager.findFragmentById(R.id.classement_nav_host) as NavHostFragment
        NavigationUI.setupWithNavController(classement_top_nav, navHost.navController)*/
    }

}