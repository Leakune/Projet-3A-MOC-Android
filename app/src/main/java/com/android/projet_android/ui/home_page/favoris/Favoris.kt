package com.android.projet_android.ui.home_page.favoris

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.projet_android.R
import com.android.projet_android.model.AlbumFavoris
import com.android.projet_android.model.Artiste
import com.android.projet_android.ui.Artiste.ListAlbum
import kotlinx.android.synthetic.main.favoris.view.*

class Favoris: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.favoris, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Artistes
        val recyclerViewArtistes = view.findViewById<RecyclerView>(R.id.list_artistes)
        val artistes: List<Artiste>
        artistes = listOf(
            generateFakeArtiste(),
            generateFakeArtiste(),
            generateFakeArtiste(),
        )
        recyclerViewArtistes.apply {
            view.list_artistes.layoutManager = LinearLayoutManager(requireContext())
            view.list_artistes.adapter = ArtisteAdapter(artistes)
        }

        //Albums
        val recyclerViewAlbums = view.findViewById<RecyclerView>(R.id.list_albums)
        val albums: List<AlbumFavoris>
        albums = listOf(
            generateFakeAlbums(),
            generateFakeAlbums(),
            generateFakeAlbums(),
        )
        recyclerViewAlbums.apply {
            view.list_albums.layoutManager = LinearLayoutManager(requireContext())
            view.list_albums.adapter = AlbumAdapter(albums)
        }
    }
    fun generateFakeArtiste() = Artiste(
        idArtist = 112024,
        strArtist = "The Weeknd",
        strArtistStripped = null,
        strArtistAlternate = "",
        strLabel = "Republic Records",
        idLabel = 47129,
        intFormedYear = 2010,
        intBornYear = 1990,
        intDiedYear = null,
        strDisbanded = null,
        strStyle = "Urban/R&B",
        strGenre = "R&B",
        strMood = "Intense",
        strWebsite = "www.the-weeknd.com",
        strFacebook = "www.facebook.com/theweeknd",
        strTwitter = "twitter.com/theweekndxo",
        strBiographyEN = "Abel Tesfaye (born February 16, 1990), better known by his stage name The Weeknd, is a Canadian R&B recording artist and record producer from Toronto, Ontario. He began recording songs under the stage name The Weeknd and uploading them to YouTube in late 2010, though his identity was initially unknown. In March 2011, The Weeknd released a nine-song free album, House of Balloons, which was critically acclaimed. The title track is based on a sample of Siouxsie and the Banshees' hit single \"Happy House.\" The first album is a part of a trilogy which includes Thursday released in August of the same year and Echoes of Silence issued in December. In June, House of Balloons was named as one of ten shortlisted nominees of 2011 Polaris Music Prize but eventually lost to Arcade Fire's The Suburbs. On December 21, 2011 at 11:07 p.m. EST Tesfaye released his highly anticipated third mixtape Echoes of Silence. On June 14, the tape was announced as a nominee for the 2012 Polaris Music Prize, becoming the second mixtape from the trilogy to receive recognition for the award.\nThe Weeknd has received praise from several music publications, including those of Pitchfork, MTV, BET, Rolling Stone, XXL and The Source, who have dubbed him the \"Songbird of his Generation\" and the \"best musical talent since Michael Jackson\" (John Norris, MTV).",
        strBiographyDE = "Abel Tesfaye (* 16. Februar 1990 in Toronto, Ontario) ist ein unter seinem K\u00fcnstlernamen The Weeknd bekannter kanadischer R&B-Singer-Songwriter. Tesfaye wurde in Scarborough geboren und ist \u00e4thiopischer Abstammung.[1] Er wuchs nach eigenen Angaben verschiedene musikalische Genres h\u00f6rend auf, u. a. Soul, Hip-Hop, Funk, Indie Rock und Post Punk. Da er ohne Vater aufgewachsen ist und die Mutter nur am arbeiten war, zog ihn seine Gro\u00dfmutter bis zum Alter von f\u00fcnf Jahren auf. Somit spricht der S\u00e4nger flie\u00dfend amharisch \u2013 es war die erste Sprache die er erlernte.\nNachdem er im Alter von 17 Jahren, gemeinsam mit einem heutigen Mitglied seiner Crew, die High School abgebrochen hat, kam er schlie\u00dflich auf seinen K\u00fcnstlernamen; \u201ean einem Wochenende verlassen und nie wieder erschienen\u201c ( \u201eleft one weekend and never came home.\u201c). Da jedoch eine kanadische Band bereits den Namen The Weekend tr\u00e4gt, hat er die Buchstabierweise modifiziert (\u201aThe Weeknd\u2018).[3]\nBekannt wurde er durch seine Zusammenarbeit mit dem ebenfalls aus Toronto stammenden Rapper Drake und seine Ver\u00f6ffentlichungen auf der Video-Plattform YouTube. Am 21. M\u00e4rz 2011 ver\u00f6ffentlichte Tesfaye sein Mixtape House of Balloons auf seiner Website zum kostenlosen Download. Am 18. August 2011 erschien das Mixtape Album Thursday, am 21. Dezember folgte das dritte, betitelt Echoes of Silence. Alle drei Alben erhielten \u00fcberwiegend positive Kritiken.\n\nAm 13. November 2012 erschien die Kompilation Trilogy, welches die drei ersten Alben und einige neue Lieder enth\u00e4lt.\n\nSein Deb\u00fctalbum Kiss Land erschien am 10. September 2013. In den USA konnte es in der ersten Woche 96.000 Exemplare absetzen und sich auf #2 der Billboard 200 platzieren.[4]",
        strBiographyFR = "Abel Tesfaye (n\u00e9 le 16 f\u00e9vrier 1990), plus connu sous le nom de sc\u00e8ne The Weeknd est un chanteur, compositeur et DJ canadien natif de Scarborough dans l'Ontario. La musique de The Weeknd est une m\u00e9lange de R'n'B, hip hop, rock avec aussi un c\u00f4t\u00e9 trip-hop.\n\nLe 6 mars 2011, le chanteur Drake parle de The Weeknd sur le r\u00e9seau twitter, suscitant la curiosit\u00e9 du public1,2. Durant l'\u00e9t\u00e9, The Weeknd met en ligne sur son site un premier album House Of Ballons qui rencontre un bon accueil critique. La chanson titre bas\u00e9e sur un sample du hit single Happy House de Siouxsie and the Banshees, est salu\u00e9e par le site influent Pitchfork3. La musique \u00e9clectique de The Weeknd combine des samples d'autres artistes comme Beach House et Aaliyah4. Deux autres mixtapes Thursday et Echoes of Silence sortent la m\u00eame ann\u00e9e.\n\nEn juin 2012, lors de son premier concert \u00e0 Londres, The Weeknd interpr\u00e8te une reprise du Dirty Diana de Michael Jackson devant un public qui comprend les chanteuses Katy Perry et Florence Welch. En novembre, The Weeknd publie chez universal un triple cd compilation Trilogy qui regroupe les trois pr\u00e9c\u00e9dentes mixtapes : chaque CD contient un titre bonus. Le RIAA, l'organisme officiel d'attribution et de certification des disques d'or et de platine, certifie Trilogy disque d'Or aux USA peu de temps apr\u00e8s sa sortie.",
        strBiographyCN = null,
        strBiographyIT = "Abel Tesfaye, conosciuto con il suo pseudonimo The Weeknd (Scarborough, 16 febbraio 1990), \u00e8 un musicista e produttore discografico canadese. Nato in Ontario, Abel Tesfaye ha origini etiopi.[1] Adotta lo pseudonimo The Weeknd all'et\u00e0 di 17 anni, quando inizia ad approcciarsi alla musica. Nel dicembre 2010 carica su YouTube alcune sue tracce, inclusa una realizzata con il rapper Drake. Si guadagna cos\u00ec l'attenzione dei media e, nel marzo 2011, rilascia un mixtape dal titolo House of Balloons, prodotto con Illangelo e Doc McKinney. Il disco viene acclamato dalla critica e riceve una nomination ai Polaris Music Prize 2011.[2] Dopo aver partecipato a numerosi festival musicali, tra cui l'OVO Fest, nell'agosto 2011 pubblica Thursday, il suo secondo mixtape. Il terzo \u00e8 invece Echoes of Silence, rilasciato nel dicembre seguente. I tre lavori vengono pubblicati tutti assieme sotto il nome di Balloons Trilogy.\n\nNell'aprile 2012 intraprende un tour negli Stati Uniti, mentre successivamente sbarca in Europa partecipando al Primavera Sound Festival (Spagna e Portogallo) ed al Wireless Festival (Londra). Tiene concerti anche a Parigi e Bruxelles. Nel settembre 2012 si accorda con la Republic Records, ma comunque continua a rilasciare materiale anche per la sua XO. La raccolta Trilogy viene rilasciata nel mese di novembre e consiste in una rimasterizzazione dei mixtape precedente con tre tracce addizionali. Questo lavoro ottiene recensioni molto positive dai siti e dalle riviste specializzate, come MTV, Pitchfork Media, Rolling Stone e BET.[3] Inoltre Trilogy viene certificato doppio disco di platino dalla Music Canada[4] e disco di platino dalla RIAA (#4 nella Billboard 200).[5]\n\nNel maggio 2013 pubblica il brano Kiss Land, che anticipa il disco omonimo, intitolato appunto Kiss Land e pubblicato nel settembre seguente. Altri singoli inclusi nell'album sono Belong to the World e Live for (feat. Drake). L'album ha raggiunto la seconda posizione della Billboard 200.[6] Collabora nel 2013 alla colonna sonora del film Hunger Games: La ragazza di fuoco, in particolare nei brani Elastic Heart e Devil May Cry.",
        strBiographyJP = null,
        strBiographyRU = null,
        strBiographyES = "Abel Tesfaye (nacido el 16 de febrero de 1990), mejor conocido por su nombre art\u00edstico The Weeknd, es un cantante, y productor et\u00edope-canadiense. Es conocido por su \u00e9xito \"Wicked Games\", as\u00ed como el uso de falsete en sus canciones.\n\nA finales del 2010, Tesfaye subi\u00f3 al portal de Youtube varias canciones bajo el seud\u00f3nimo de \"The Weeknd\", manteniendo su verdadera identidad en el anonimato. En el 2011, lanz\u00f3 tres mixtapes de nueve canciones, que est\u00e1n disponibles solo para su descarga digital: House of Balloons, Thursday, y Echoes of Silence, que fueron muy aclamados por la cr\u00edtica. En el 2012, lanz\u00f3 un \u00e1lbum recopilatorio, Trilogy, que consiste en versiones remasterizadas de las canciones contenidas en los mixtapes, as\u00ed como tres canciones nuevas. Fue lanzado al mercado bajo el sello de Universal Republic Records, y su propio sello XO.\n\nThe Weeknd ha recibido elogio de parte de publicaciones musicales, incluyendo Pitchfork, MTV, BET, Rolling Stone, XXL y The Source, quienes lo han proclamado como el \"ave cantora de su generaci\u00f3n\" y el \"mejor talento musical desde Michael Jackson\" (John Norris, MTV).",
        strBiographyPT = null,
        strBiographySE = null,
        strBiographyNL = null,
        strBiographyHU = null,
        strBiographyNO = null,
        strBiographyIL = null,
        strBiographyPL = null,
        strGender = "Male",
        intMembers = 1,
        strCountry = "Toronto, Canada",
        strCountryCode = "CA",
        strArtistThumb = "https://www.theaudiodb.com/images/media/artist/thumb/vtxqyp1495060298.jpg",
        strArtistLogo = "https://www.theaudiodb.com/images/media/artist/logo/the-weeknd-4ee692822a3aa.png",
        strArtistClearart = "https://www.theaudiodb.com/images/media/artist/clearart/uvtspy1515697860.png",
        strArtistWideThumb = "https://www.theaudiodb.com/images/media/artist/widethumb/xsswwv1524670158.jpg",
        strArtistFanart = "https://www.theaudiodb.com/images/media/artist/fanart/the-weeknd-4ee6928ad3a11.jpg",
        strArtistFanart2 = "https://www.theaudiodb.com/images/media/artist/fanart/the-weeknd-4ee693dd07fe9.jpg",
        strArtistFanart3 = "https://www.theaudiodb.com/images/media/artist/fanart/yyvtpq1342552236.jpg",
        strArtistFanart4 = "https://www.theaudiodb.com/images/media/artist/fanart/xmghh51613145224.jpg",
        strArtistBanner = "https://www.theaudiodb.com/images/media/artist/banner/xqttqs1408106880.jpg",
        strMusicBrainzID = "c8b03190-306c-4120-bb0b-6f2ebfc06ea9",
        strISNIcode = null,
        strLastFMChart = "http://www.last.fm/music/The Weeknd/+charts?rangetype=6month",
        intCharted = 4,
        strLocked = "unlocked"
    )

    fun generateFakeAlbums() = AlbumFavoris(
        idAlbum = "2115886",
        idArtist = "112024",
        strAlbum = "Thursday",
        strArtist = "The Weeknd",
        strAlbumThumb = "https://www.theaudiodb.com/images/media/album/thumb/thursday-4ee69293cd094.jpg"
    )
}