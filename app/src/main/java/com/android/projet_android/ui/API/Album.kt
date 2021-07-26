package com.android.projet_android.ui.API


import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.io.Serializable

interface APIAlbum {
    @GET("searchalbum.php")
    fun getAlbumByArtisteName(@Query("s")value:String): Deferred<AlbumData>
}

object NetworkAlbum {
    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APIAlbum::class.java)
}


data class AlbumData(
    @SerializedName("album")
    val content: ArrayList<Album>,
): Serializable

data class Album(
    @SerializedName("idAlbum")
    val idAlbum: String,
    @SerializedName("idArtist")
    val idArtist: String,
    @SerializedName("idLabel")
    val idLabel: String,
    @SerializedName("intLoved")
    val intLoved: Any,
    @SerializedName("intSales")
    val intSales: String,
    @SerializedName("intScore")
    val intScore: String,
    @SerializedName("intScoreVotes")
    val intScoreVotes: String,
    @SerializedName("intYearReleased")
    val intYearReleased: String,
    @SerializedName("strAlbum")
    val strAlbum: String,
    @SerializedName("strAlbum3DCase")
    val strAlbum3DCase: Any,
    @SerializedName("strAlbum3DFace")
    val strAlbum3DFace: Any,
    @SerializedName("strAlbum3DFlat")
    val strAlbum3DFlat: Any,
    @SerializedName("strAlbum3DThumb")
    val strAlbum3DThumb: Any,
    @SerializedName("strAlbumCDart")
    val strAlbumCDart: String,
    @SerializedName("strAlbumSpine")
    val strAlbumSpine: Any,
    @SerializedName("strAlbumStripped")
    val strAlbumStripped: String,
    @SerializedName("strAlbumThumb")
    val strAlbumThumb: String,
    @SerializedName("strAlbumThumbBack")
    val strAlbumThumbBack: Any,
    @SerializedName("strAlbumThumbHQ")
    val strAlbumThumbHQ: Any,
    @SerializedName("strAllMusicID")
    val strAllMusicID: Any,
    @SerializedName("strAmazonID")
    val strAmazonID: Any,
    @SerializedName("strArtist")
    val strArtist: String,
    @SerializedName("strArtistStripped")
    val strArtistStripped: String,
    @SerializedName("strBBCReviewID")
    val strBBCReviewID: String,
    @SerializedName("strDescription")
    val strDescription: Any,
    @SerializedName("strDescriptionCN")
    val strDescriptionCN: Any,
    @SerializedName("strDescriptionDE")
    val strDescriptionDE: Any,
    @SerializedName("strDescriptionEN")
    val strDescriptionEN: String,
    @SerializedName("strDescriptionES")
    val strDescriptionES: Any,
    @SerializedName("strDescriptionFR")
    val strDescriptionFR: Any,
    @SerializedName("strDescriptionHU")
    val strDescriptionHU: Any,
    @SerializedName("strDescriptionIL")
    val strDescriptionIL: Any,
    @SerializedName("strDescriptionIT")
    val strDescriptionIT: Any,
    @SerializedName("strDescriptionJP")
    val strDescriptionJP: Any,
    @SerializedName("strDescriptionNL")
    val strDescriptionNL: Any,
    @SerializedName("strDescriptionNO")
    val strDescriptionNO: Any,
    @SerializedName("strDescriptionPL")
    val strDescriptionPL: Any,
    @SerializedName("strDescriptionPT")
    val strDescriptionPT: Any,
    @SerializedName("strDescriptionRU")
    val strDescriptionRU: Any,
    @SerializedName("strDescriptionSE")
    val strDescriptionSE: Any,
    @SerializedName("strDiscogsID")
    val strDiscogsID: Any,
    @SerializedName("strGeniusID")
    val strGeniusID: String,
    @SerializedName("strGenre")
    val strGenre: String,
    @SerializedName("strItunesID")
    val strItunesID: Any,
    @SerializedName("strLabel")
    val strLabel: String,
    @SerializedName("strLocation")
    val strLocation: Any,
    @SerializedName("strLocked")
    val strLocked: String,
    @SerializedName("strLyricWikiID")
    val strLyricWikiID: Any,
    @SerializedName("strMood")
    val strMood: String,
    @SerializedName("strMusicBrainzArtistID")
    val strMusicBrainzArtistID: String,
    @SerializedName("strMusicBrainzID")
    val strMusicBrainzID: String,
    @SerializedName("strMusicMozID")
    val strMusicMozID: Any,
    @SerializedName("strRateYourMusicID")
    val strRateYourMusicID: Any,
    @SerializedName("strReleaseFormat")
    val strReleaseFormat: String,
    @SerializedName("strReview")
    val strReview: String,
    @SerializedName("strSpeed")
    val strSpeed: Any,
    @SerializedName("strStyle")
    val strStyle: String,
    @SerializedName("strTheme")
    val strTheme: Any,
    @SerializedName("strWikidataID")
    val strWikidataID: Any,
    @SerializedName("strWikipediaID")
    val strWikipediaID: Any
)