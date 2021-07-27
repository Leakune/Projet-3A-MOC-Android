package com.android.projet_android.ui.Artiste

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.ui.Album.Album
import com.g123k.myapplication.network.AlbumDataNameYears
import com.g123k.myapplication.network.NetworkAlbum
import kotlinx.android.synthetic.main.list_album.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListAlbum(val artistName: String):Fragment(), onItemClickListener {

    // Equivalent du setContentView : qu'afficher à l'écran ?
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Similaire à setContentView(R.layout.list_fragment)
        return inflater.inflate(R.layout.list_album, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        GlobalScope.launch(Dispatchers.Default){

            val recyclerView = view.findViewById<RecyclerView>(R.id.list_album)
            val titleAlbum = view.findViewById<TextView>(R.id.numberAlbum)
            val dataAlbumDataResume = NetworkAlbum.api.getAlbumNameYearsByArtisteDataAsync(artistName).await()

            withContext(Dispatchers.Main){
                recyclerView.apply {
                    /*view.list_album.addItemDecoration(
                        DividerItemDecoration(
                            requireContext(),
                            DividerItemDecoration.VERTICAL
                        )
                    )*/
                    titleAlbum.text = "Album (" + dataAlbumDataResume.content.size + ")"
                    view.list_album.layoutManager = LinearLayoutManager(requireContext())
                    adapter = AlbumAdapter(dataAlbumDataResume, this@ListAlbum)

                }
            }


        }
    }

    class AlbumAdapter(private val album: AlbumDataNameYears, var clickListener: onItemClickListener) : RecyclerView.Adapter<AlbumViewHolder>() {

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

            holder.initialize(album, clickListener)
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

        fun initialize(item: AlbumDataNameYears, action: onItemClickListener){
            itemView.setOnClickListener {
                action.onItemClick(item, adapterPosition)
            }
        }

    }

    override fun onItemClick(myDataItem: AlbumDataNameYears, position: Int) {

        Log.e("Tag", myDataItem.content[position].strAlbum)

        val fragment = Album()
        val args = Bundle()
        args.putString("strAlbum", myDataItem.content[position].strAlbum)
        fragment.arguments = args

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container_view, fragment)
            .commitAllowingStateLoss()
    }

}

interface onItemClickListener{
    fun onItemClick(myDataItem: AlbumDataNameYears, position: Int)
}