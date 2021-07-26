package com.android.projet_android.ui.home_page.recherche

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.model.AlbumFavoris
import com.android.projet_android.ui.API.AlbumData
import com.android.projet_android.ui.API.ArtisteData
import com.android.projet_android.ui.API.NetworkAlbum
import com.android.projet_android.ui.API.NetworkArtiste
import com.android.projet_android.ui.details.Artiste
import com.android.projet_android.ui.home_page.favoris.AlbumAdapter
import com.android.projet_android.ui.home_page.favoris.ArtisteAdapter
import kotlinx.android.synthetic.main.favoris.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Rechercher : Fragment(){
    lateinit var mContext: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.rechercher, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Artistes
        val recyclerViewArtistes = view.findViewById<RecyclerView>(R.id.list_artistes)

        //Albums
        val recyclerViewAlbums = view.findViewById<RecyclerView>(R.id.list_albums)

        val search = view.findViewById<EditText>(R.id.search_bar)
        search.setOnEditorActionListener (object: TextView.OnEditorActionListener {
            override fun onEditorAction(
                v: TextView?,
                actionId: Int,
                event: KeyEvent?
            ): Boolean {
                GlobalScope.launch(Dispatchers.Default){
                    try {
                        withContext(Dispatchers.Main) {
                            val search = v?.findViewById<EditText>(R.id.search_bar)
                            val dataArtistes: ArtisteData =
                                NetworkArtiste.api.getArtisteByNameAPI(search?.text.toString())
                                    .await()

                            val dataAlbums: AlbumData =
                                NetworkAlbum.api.getAlbumByArtisteName(search?.text.toString())
                                    .await()

                            recyclerViewArtistes.apply {
                                view.list_artistes.layoutManager =
                                    LinearLayoutManager(requireContext())
                                if(dataArtistes.content != null){
                                    view.list_artistes.adapter = ArtisteAdapter(dataArtistes)
                                }
                            }

                            recyclerViewAlbums.apply {
                                view.list_albums.layoutManager = LinearLayoutManager(requireContext())
                                if(dataArtistes.content != null){
                                    view.list_albums.adapter = AlbumAdapter(dataAlbums)
                                }
                            }
                        }
                    }
                    catch (e: Exception) {
                        withContext(Dispatchers.Main) {
                        }
                    }
                }
                return false
            }
        })
    }
}