package com.android.projet_android.ui.Artiste

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.g123k.myapplication.network.ArtistTopTrackData
import com.g123k.myapplication.network.NetworkArtistToptrack
import kotlinx.android.synthetic.main.list_album.view.*
import kotlinx.android.synthetic.main.list_title_appreciate.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListTitleAppreciate(val artistName: String): Fragment() {

    // Equivalent du setContentView : qu'afficher à l'écran ?
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Similaire à setContentView(R.layout.list_fragment)
        return inflater.inflate(R.layout.list_title_appreciate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Default){

            val recyclerView = view.findViewById<RecyclerView>(R.id.list_title_appreciate)
            val title = NetworkArtistToptrack.api.getArtistsTopByNameDataAsync(artistName).await()

            withContext(Dispatchers.Main){
                recyclerView.apply {
                    view.list_title_appreciate.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
                    view.list_title_appreciate.layoutManager = LinearLayoutManager(requireContext())
                    adapter = TitleAdapter(title)

                }
            }

        }

    }

    class TitleAdapter(private val title: ArtistTopTrackData) : RecyclerView.Adapter<TitleViewHolder>() {

        override fun getItemCount(): Int {
            //return album.size
            return title.content.size
        }

        // Comment créer une cellule
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleViewHolder {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.titre_appreciate_cell, parent, false)

            return TitleViewHolder(view)
        }

        // Comment mettre à jour une cellule
        override fun onBindViewHolder(holder: TitleViewHolder, position: Int) {
            return holder.bindView(position,title)
        }

    }

    // Une cellule
    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val idTitle: TextView = itemView.findViewById(R.id.numberTitle)
        private val title: TextView = itemView.findViewById(R.id.nameTitle)

        fun bindView(position: Int,album: ArtistTopTrackData) {

            idTitle.text = (position + 1).toString()
            title.text = album.content[position].strTrack

        }
    }

}