package com.android.projet_android.ui.API

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/*data class DataAlbum {

    @SerializedName("album.strAlbum")
    var title: String,

    @SerializedName("album.intYearReleased")
    var year: String


}*/

class DataAlbum(s: String, i: Int) {


    @SerializedName("strAlbum")
    @Expose
    private var title: String? = null


    @SerializedName("yearAlbum")
    @Expose
    private var year: String? = null

}

/*
data class DataCoursePropose(
    @SerializedName("id")
    val id: String,
    @SerializedName("libelle")
    val libelle: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("userId")
    val userId: String
)
 */