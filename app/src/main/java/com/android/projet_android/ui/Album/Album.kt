package com.android.projet_android.ui.Album

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.projet_android.R
import com.android.projet_android.ui.home_page.HomePage

class Album: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.album, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val strAlbum = arguments?.getString("strAlbum")

        Log.e("Tag123", strAlbum.toString())

        /*parentFragmentManager
            .beginTransaction()
            .replace(R.id.container1, Picture())
            .commitAllowingStateLoss()*/


    }

}