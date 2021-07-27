package com.g123k.myapplication.network
import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class AlbumData(
    @SerializedName("album")
    val content: List<AlbumDataContent>,
)

data class AlbumDataNameYears(
    @SerializedName("album")
    val content: List<AlbumDataResume>,
)

data class AlbumDataContent(
    val idArtist: String,
    val strAlbum: String,
    val strGenre: String,
    val strArtist:String,
    val intYearReleased: String,
    val strAlbumThumb: String,
    val intScore: String,
    val intScoreVotes: String,

)

data class AlbumDataResume(
    val strAlbum: String,
    val intYearReleased: String,

)

interface APIAlbum {

    @GET("album.php")
    fun getAlbumByIDDataAsync(@Query("m")value:String): Deferred<AlbumData>

    @GET("discography.php")
    fun getAlbumNameYearsByArtisteDataAsync(@Query("s")value:String): Deferred<AlbumDataNameYears>

    @GET("searchalbum.php")
    fun getAlbumByAtisteName(@Query("s")value:String): Deferred<AlbumData>
}


object NetworkAlbum {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APIAlbum::class.java)

}