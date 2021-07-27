package com.g123k.myapplication.network
import com.google.gson.annotations.SerializedName
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

data class TrackSongData(
    @SerializedName("track")
    val content: List<TrackDataContent>,
)

data class TrackDataContent(
    val idTrack: String,
    val strTrack: String,
    val strAlbum: String,
    var strArtist: String,
    val intTrackNumber: String,

)

interface APITrack {

    @GET("track.php")
    fun getTrackByAlbumIdDataAsync(@Query("m")value:String): Deferred<TrackSongData>
}


object NetworkTrack {

    val api = Retrofit.Builder()
        .baseUrl("https://theaudiodb.com/api/v1/json/523532/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()
        .create(APITrack::class.java)

}