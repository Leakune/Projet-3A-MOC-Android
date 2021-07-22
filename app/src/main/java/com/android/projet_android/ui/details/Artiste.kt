package com.android.projet_android.ui.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.projet_android.R
import com.android.projet_android.ui.home_page.Favoris
import com.android.projet_android.ui.home_page.Rechercher

class Artiste: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.artiste)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container1, Favoris())
            .replace(R.id.container2, Rechercher())
            .replace(R.id.container3, Rechercher())
            .commitAllowingStateLoss()
    }

}