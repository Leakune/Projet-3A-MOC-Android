package com.android.projet_android.ui.home_page.favoris

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.ui.API.ArtisteData
import com.android.projet_android.ui.API.ArtisteDataContent
import com.android.projet_android.ui.Test
import com.android.projet_android.ui.details.Artiste
import com.android.projet_android.ui.home_page.recherche.Rechercher
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ArtisteAdapter(private val listArtiste: ArtisteData) : RecyclerView.Adapter<ArtisteCell>() {

    override fun getItemCount(): Int {
        return listArtiste.content.size
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
        holder.updateCell(
            listArtiste.content.get(position)
        )
        return holder.itemView.setOnClickListener {
            GlobalScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) {
                    val intent = Intent(holder.itemView.findFragment<Rechercher>().mContext, Artiste::class.java)
                    intent.putExtra("id", listArtiste.content.get(position).idArtist);
                    //holder.itemView.findFragment<Rechercher>().mContext.startActivity(intent)
                    Log.e("TAG", "Test")
                }
            }
            /*var fr = getFragmentManager()?.beginTransaction()
            fr?.replace(R.id.fragment, Fragment_Two())
            fr?.commit()*/

        }
    }
}

// Une cellule
class ArtisteCell(v: View, listArtiste: ArtisteData) : RecyclerView.ViewHolder(v) {
    private val imageArtiste: ImageView = v.findViewById(R.id.image_artiste)
    private val titleArtiste: TextView = v.findViewById(R.id.title_artiste)
    var idArtiste=""
    init {
        titleArtiste.setOnClickListener {
            val intent = Intent(v.context, Test::class.java)
            GlobalScope.launch(Dispatchers.Default) {
                withContext(Dispatchers.Main) {
                    intent.putExtra("id", listArtiste.content[position].strArtist);
                    v.context.startActivity(intent)
                }
            }
        }
    }

    fun updateCell(artiste: ArtisteDataContent) {
        titleArtiste.text = artiste.strArtist
        idArtiste = artiste.idArtist
        if(artiste.strArtistThumb != null && artiste.strArtistThumb != ""){
            Picasso.get().load(artiste.strArtistThumb).into(imageArtiste)
        }
    }

}