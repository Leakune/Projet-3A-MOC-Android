package com.android.projet_android.ui.home_page.classement

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.projet_android.R

class Titres: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.titres, container, false)
    }
    override fun onViewCreated(view: View,
                               savedInstanceState: Bundle?) {
        // Assignez les valeurs à vos textes, images...
        super.onViewCreated(view, savedInstanceState)
    }
}