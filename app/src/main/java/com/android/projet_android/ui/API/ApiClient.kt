package com.android.projet_android.ui.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.theaudiodb.com/api/v1/json/1")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

}