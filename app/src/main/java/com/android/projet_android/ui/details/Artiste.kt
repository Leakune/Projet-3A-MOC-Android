package com.android.projet_android.ui.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.projet_android.R
import com.android.projet_android.ui.Artiste.ListAlbum
import com.android.projet_android.ui.Artiste.ListDescription
import com.android.projet_android.ui.Artiste.ListTitleAppreciate
import com.android.projet_android.ui.Artiste.Picture

class Artiste: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.artiste, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val artistName = arguments?.getString("nameArtist")

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container1, Picture(artistName!!))
            .replace(R.id.container2, ListDescription(artistName!!))
            .replace(R.id.container3, ListAlbum(artistName!!))
            .replace(R.id.container4, ListTitleAppreciate(artistName!!))
            .commitAllowingStateLoss()
    }

}