package com.android.projet_android.ui.API

import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import java.io.Serializable

interface API {
    @GET("search.php")
    fun getArtisteByNameAPI(@Query("s")value:String): Deferred<ArtisteData>

}

object NetworkArtiste {
    val api = Retrofit.Builder()
        .baseUrl("https://www.theaudiodb.com/api/v1/json/1/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(API::class.java)
}


data class ArtisteData(
    @SerializedName("artists")
    val content: ArrayList<ArtisteDataContent>,
): Serializable

data class ArtisteDataContent(
    @SerializedName("idArtist")
    val idArtist: String,
    @SerializedName("strArtist")
    val strArtist: String?,
    @SerializedName("strArtistStripped")
    val strArtistStripped: String?,
    @SerializedName("strArtistAlternate")
    val strArtistAlternate: String,
    @SerializedName("strLabel")
    val strLabel: String?,
    @SerializedName("idLabel")
    val idLabel: String?,
    @SerializedName("intFormedYear")
    val intFormedYear: String?,
    @SerializedName("intDiedYear")
    val intDiedYear: Integer?,
    @SerializedName("intBornYear")
    val intBornYear: String?,
    @SerializedName("strDisbanded")
    val strDisbanded: String?,
    @SerializedName("strStyle")
    val strStyle: String?,
    @SerializedName("strGenre")
    val strGenre: String?,
    @SerializedName("strMood")
    val strMood: String?,
    @SerializedName("strWebsite")
    val strWebsite: String?,
    @SerializedName("strFacebook")
    val strFacebook: String?,
    @SerializedName("strTwitter")
    val strTwitter: String?,
    @SerializedName("strBiographyEN")
    val strBiographyEN: String?,
    @SerializedName("strBiographyDE")
    val strBiographyDE: String?,
    @SerializedName("strBiographyFR")
    val strBiographyFR: String?,
    @SerializedName("strBiographyCN")
    val strBiographyCN: String?,
    @SerializedName("strBiographyIT")
    val strBiographyIT: String?,
    @SerializedName("strBiographyJP")
    val strBiographyJP: String?,
    @SerializedName("strBiographyRU")
    val strBiographyRU: String?,
    @SerializedName("strBiographyES")
    val strBiographyES: String?,
    @SerializedName("strBiographyPT")
    val strBiographyPT: String?,
    @SerializedName("strBiographySE")
    val strBiographySE: String?,
    @SerializedName("strBiographyNL")
    val strBiographyNL: String?,
    @SerializedName("strBiographyHU")
    val strBiographyHU: String?,
    @SerializedName("strBiographyNO")
    val strBiographyNO: String?,
    @SerializedName("strBiographyIL")
    val strBiographyIL: String?,
    @SerializedName("strBiographyPL")
    val strBiographyPL: String?,
    @SerializedName("strGender")
    val strGender: String?,
    @SerializedName("intMembers")
    val intMembers: String?,
    @SerializedName("strCountry")
    val strCountry: String?,
    @SerializedName("strCountryCode")
    val strCountryCode: String?,
    @SerializedName("strArtistThumb")
    val strArtistThumb: String?,
    @SerializedName("strArtistLogo")
    val strArtistLogo: String?,
    @SerializedName("strArtistClearart")
    val strArtistClearart: String?,
    @SerializedName("strArtistWideThumb")
    val strArtistWideThumb: String?,
    @SerializedName("strArtistFanart")
    val strArtistFanart: String?,
    @SerializedName("strArtistFanart2")
    val strArtistFanart2: String?,
    @SerializedName("strArtistFanart3")
    val strArtistFanart3: String?,
    @SerializedName("strArtistFanart4")
    val strArtistFanart4: String?,
    @SerializedName("strArtistBanner")
    val strArtistBanner: String?,
    @SerializedName("strMusicBrainzID")
    val strMusicBrainzID: String?,
    @SerializedName("strISNIcode")
    val strISNIcode: String?,
    @SerializedName("strLastFMChart")
    val strLastFMChart: String?,
    @SerializedName("intCharted")
    val intCharted: String?,
    @SerializedName("strLocked")
    val strLocked: String?,
): Serializable