package com.android.projet_android.ui.home_page.favoris

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.model.Artiste
import com.squareup.picasso.Picasso


class ArtisteAdapter(private val listArtiste: List<Artiste>) : RecyclerView.Adapter<ArtisteCell>() {

    override fun getItemCount(): Int {
        return listArtiste.size
        //return 5
    }

    // Comment créer une cellule
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtisteCell {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.artiste_cell, parent, false)

        return ArtisteCell(view)
    }

    // Comment mettre à jour une cellule
    override fun onBindViewHolder(holder: ArtisteCell, position: Int) {
        return holder.updateCell(
            listArtiste.get(position)
        )
    }

}

// Une cellule
class ArtisteCell(v: View) : RecyclerView.ViewHolder(v) {
    private val imageArtiste: ImageView = v.findViewById(R.id.image_artiste)
    private val titleArtiste: TextView = v.findViewById(R.id.title_artiste)

    fun updateCell(artiste: Artiste) {
        titleArtiste.text = artiste.strArtist
        Picasso.get().load(artiste.strArtistThumb).into(imageArtiste)
    }

}