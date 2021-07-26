package com.android.projet_android.ui.Artiste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.g123k.myapplication.network.AlbumDataNameYears
import com.g123k.myapplication.network.NetworkAlbum
import kotlinx.android.synthetic.main.list_album.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListAlbum :Fragment() {

    // Equivalent du setContentView : qu'afficher à l'écran ?
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Similaire à setContentView(R.layout.list_fragment)
        return inflater.inflate(R.layout.list_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Default){

            val recyclerView = view.findViewById<RecyclerView>(R.id.list_album)
            val dataAlbumDataResume = NetworkAlbum.api.getAlbumNameYearsByArtisteDataAsync("The Weeknd").await()

            withContext(Dispatchers.Main){
                recyclerView.apply {
                    /*view.list_album.addItemDecoration(
                        DividerItemDecoration(
                            requireContext(),
                            DividerItemDecoration.VERTICAL
                        )
                    )*/
                    view.list_album.layoutManager = LinearLayoutManager(requireContext())
                    adapter = AlbumAdapter(dataAlbumDataResume)

                }
            }


        }
    }

    class AlbumAdapter(private val album: AlbumDataNameYears) : RecyclerView.Adapter<AlbumViewHolder>() {

        override fun getItemCount(): Int {
            //return album.size
            return album.content.size
        }

        // Comment créer une cellule
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.album_cell, parent, false)

            return AlbumViewHolder(view)
        }

        // Comment mettre à jour une cellule
        override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {

            return holder.bindView(position, album)
        }

    }

    // Une cellule
    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val titleAlbum: TextView = itemView.findViewById(R.id.titleAlbum)
        private val yearAlbum: TextView = itemView.findViewById(R.id.yearAlbum)

        fun bindView(position: Int, album: AlbumDataNameYears) {

            titleAlbum.text = album.content[position].strAlbum
            yearAlbum.text = album.content[position].intYearReleased

        }
    }

}