package com.android.projet_android.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.android.projet_android.R
import com.android.projet_android.databinding.ActivityMainBinding
import com.android.projet_android.ui.details.Artiste
import com.android.projet_android.ui.home_page.HomePage

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.artiste)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<Artiste>(R.id.container_view)
            }
        }

    }

}