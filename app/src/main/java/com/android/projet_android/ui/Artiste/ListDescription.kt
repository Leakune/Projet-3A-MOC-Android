package com.android.projet_android.ui.Artiste

import android.os.Bundle
import android.util.EventLogTags
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.ui.API.DataAlbum
import kotlinx.android.synthetic.main.list_album.view.*
import kotlinx.android.synthetic.main.list_description.view.*

class ListDescription: Fragment() {

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

        val recyclerView = view.findViewById<RecyclerView>(R.id.list_description)

        val test = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        recyclerView.apply {
            view.list_description.layoutManager = LinearLayoutManager(requireContext())
            view.list_description.adapter = DescriptionAdapter(test)

        }

    }

    class DescriptionAdapter(private val description: String) : RecyclerView.Adapter<DescriptionViewHolder>() {

        override fun getItemCount(): Int {
            //return album.size
            return 5
        }

        // Comment créer une cellule
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescriptionViewHolder {

            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.description_cell, parent, false)

            return DescriptionViewHolder(view)
        }

        // Comment mettre à jour une cellule
        override fun onBindViewHolder(holder: DescriptionViewHolder, position: Int) {
            return holder.bindView(description)
        }

    }

    // Une cellule
    class DescriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val desc: TextView = itemView.findViewById(R.id.description)

        fun bindView(description: String) {

            desc.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

        }
    }

}