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
import com.g123k.myapplication.network.ArtistData
import com.g123k.myapplication.network.NetworkArtist
import kotlinx.android.synthetic.main.list_description.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListDescription(val artistName: String): Fragment() {

    // Equivalent du setContentView : qu'afficher à l'écran ?
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Similaire à setContentView(R.layout.list_fragment)
        return inflater.inflate(R.layout.list_description, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Default) {

            val recyclerView = view.findViewById<RecyclerView>(R.id.list_description)
            val desc = NetworkArtist.api.getArtistsDetailsByArtistNameDataAsync(artistName).await()

            withContext(Dispatchers.Main){
                recyclerView.apply {
                    view.list_description.layoutManager = LinearLayoutManager(requireContext())
                    view.list_description.adapter = DescriptionAdapter(desc)

                }
            }

        }

    }

    class DescriptionAdapter(private val description: ArtistData) : RecyclerView.Adapter<DescriptionViewHolder>() {

        override fun getItemCount(): Int {
            //return album.size
            return description.content.size
        }

        // Comment créer une cellule
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.description_cell, parent, false)

            return DescriptionViewHolder(view)
        }

        // Comment mettre à jour une cellule
        override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
            return holder.bindView(position, description)
        }

    }

    // Une cellule
    class DescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val desc: TextView = itemView.findViewById(R.id.description)

        fun bindView(position: Int, description: ArtistData) {

            desc.text = description.content[position].strBiographyEN

        }
    }

}