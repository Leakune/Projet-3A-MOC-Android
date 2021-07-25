package com.android.projet_android.ui.home_page.favoris

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.model.AlbumFavoris
import com.squareup.picasso.Picasso

class AlbumAdapter(private val listAlbum: List<AlbumFavoris>) : RecyclerView.Adapter<AlbumCell>() {

    override fun getItemCount(): Int {
        return listAlbum.size
        //return 5
    }

    // Comment créer une cellule
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumCell {

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.album_cell, parent, false)

        return AlbumCell(view)
    }

    // Comment mettre à jour une cellule
    override fun onBindViewHolder(holder: AlbumCell, position: Int) {
        return holder.updateCell(
            listAlbum.get(position)
        )
    }

}

// Une cellule
class AlbumCell(v: View) : RecyclerView.ViewHolder(v) {
    private val imageAlbum: ImageView = v.findViewById(R.id.image_album)
    private val titleAlbum: TextView = v.findViewById(R.id.titleAlbum)
    private val nameArtiste: TextView = v.findViewById(R.id.yearAlbum)
    fun updateCell(album: AlbumFavoris) {
        titleAlbum.text = album.strAlbum
        nameArtiste.text = album.strArtist
        Picasso.get().load(album.strAlbumThumb).into(imageAlbum)
    }

}