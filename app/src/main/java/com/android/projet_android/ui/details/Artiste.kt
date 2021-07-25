package com.android.projet_android.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.projet_android.R
import com.android.projet_android.ui.Artiste.ListAlbum
import com.android.projet_android.ui.Artiste.ListDescription
import com.android.projet_android.ui.Artiste.ListTitleAppreciate
import com.android.projet_android.ui.Artiste.Picture
import com.android.projet_android.ui.home_page.Favoris
import com.android.projet_android.ui.home_page.Rechercher

class Artiste: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.artiste, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container1, Picture())
            .replace(R.id.container2, ListDescription())
            .replace(R.id.container3, ListAlbum())
            .replace(R.id.container4, ListTitleAppreciate())
            .commitAllowingStateLoss()
    }

}