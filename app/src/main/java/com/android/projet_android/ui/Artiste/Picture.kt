package com.android.projet_android.ui.Artiste

import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.g123k.myapplication.network.NetworkArtist
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_description.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Picture : Fragment() {

    // Equivalent du setContentView : qu'afficher à l'écran ?
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Similaire à setContentView(R.layout.list_fragment)
        return inflater.inflate(R.layout.picture, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Default) {

            val imageView = view.findViewById<ImageView>(R.id.imgArtiste)
            val api = NetworkArtist.api.getArtistsDetailsByArtistNameDataAsync("The Weeknd").await()
            val url = api.content[0].strArtistThumb
            val title = view.findViewById<TextView>(R.id.titleArtiste)
            val subTitle = view.findViewById<TextView>(R.id.subTitle)

            withContext(Dispatchers.Main){
                Picasso.get().load(url).into(imageView)
                title.text = api.content[0].strArtist
                subTitle.text = api.content[0].strCountry + " - " + api.content[0].strGenre
            }

        }

    }
}