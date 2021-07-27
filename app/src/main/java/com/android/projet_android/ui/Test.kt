package com.android.projet_android.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.android.projet_android.R
import com.android.projet_android.databinding.ActivityMainBinding
import com.android.projet_android.ui.Artiste.ListAlbum
import com.android.projet_android.ui.Artiste.ListDescription
import com.android.projet_android.ui.Artiste.ListTitleAppreciate
import com.android.projet_android.ui.Artiste.Picture
import com.android.projet_android.ui.details.Artiste
import com.android.projet_android.ui.home_page.HomePage

class Test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.artiste)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_main)

        val tst = intent.getStringExtra("nameArtist")

        val fragment = Artiste()
        val args = Bundle()
        args.putString("nameArtist", tst)
        fragment.arguments = args

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_view, fragment)
            .commitAllowingStateLoss()

    }

}