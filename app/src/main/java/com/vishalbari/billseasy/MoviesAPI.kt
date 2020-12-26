package com.vishalbari.billseasy

import android.util.Log
import com.google.gson.Gson
import com.vishalbari.billseasy.models.MoviesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MoviesAPI {
    interface MovieData
    {
        @GET("?api_key=fc6478083778c147d575a8c3e4245a5a")
        fun getMovies(): Call<MoviesModel>
    }

}