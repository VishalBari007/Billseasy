package com.vishalbari.billseasy

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.vishalbari.billseasy.adapters.MoviesAdapter
import com.vishalbari.billseasy.models.MoviesDetailsModel
import com.vishalbari.billseasy.models.MoviesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    val BASE_API:String = "https://api.themoviedb.org/3/movie/now_playing/";
    private lateinit var movieAdapter: MoviesAdapter
    lateinit var recyclerView:RecyclerView
    lateinit var progressDialog:ProgressDialog
    val moviesList: ArrayList<MoviesDetailsModel> = ArrayList<MoviesDetailsModel>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  actionBar?.setDisplayHomeAsUpEnabled(true)
        setContentView(R.layout.activity_main);
         recyclerView = findViewById(R.id.rvRecycler)
        progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please wait.....")
        progressDialog.setCancelable(false)
        progressDialog.show()

        getMoviesData()
    }
    private val TAG = "MainActivity"
    fun getMoviesData()
    {
        val retrofit: Retrofit = Retrofit.Builder().baseUrl(BASE_API).addConverterFactory(
            GsonConverterFactory.create()).build()
        val service = retrofit.create(MoviesAPI.MovieData::class.java)

        val call = service.getMovies()
        call.enqueue(object : Callback<MoviesModel> {
            override fun onResponse(call: Call<MoviesModel>, response: Response<MoviesModel>) {
                if (response.code() == 200) {
                    progressDialog.dismiss()
                    val moviesModel = response.body()!!
                    for (result in moviesModel.results) {
                        var moviesDetailsModel = MoviesDetailsModel()
                        moviesDetailsModel.adult = result.adult
                        moviesDetailsModel.backdropPath = result.backdropPath
                        moviesDetailsModel.genreIds = result.genreIds
                        moviesDetailsModel.id = result.id
                        moviesDetailsModel.originalLanguage = result.originalLanguage
                        moviesDetailsModel.originalTitle = result.originalTitle
                        moviesDetailsModel.overview = result.overview
                        moviesDetailsModel.popularity = result.popularity
                        moviesDetailsModel.posterPath = result.posterPath
                        moviesDetailsModel.releaseDate = result.releaseDate
                        moviesDetailsModel.title = result.title
                        moviesDetailsModel.video = result.video
                        moviesDetailsModel.voteAverage = result.voteAverage
                        moviesDetailsModel.voteCount = result.voteCount

                        moviesList.add(moviesDetailsModel)
                    }
                    movieAdapter = MoviesAdapter(applicationContext, moviesList);
                    recyclerView.adapter = movieAdapter
                }
            }

            override fun onFailure(call: Call<MoviesModel>, t: Throwable) {
                Log.d(TAG, "onFailure: " + t.message)
                Log.d(TAG, "onFailure: " + t.printStackTrace())
                Toast.makeText(applicationContext, "Something went wrong.", Toast.LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })
    }
}