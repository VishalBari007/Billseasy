package com.vishalbari.billseasy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.vishalbari.billseasy.models.MoviesDetailsModel

class movieDetailsActivity : AppCompatActivity() {

    private val TAG = "movieDetailsActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        var title: TextView = findViewById(R.id.mv_title)
        var postdate: TextView = findViewById(R.id.mv_postDate)
        var overview: TextView = findViewById(R.id.mv_overview)
        var popularity: TextView = findViewById(R.id.mv_popularity)
        var votcount: TextView = findViewById(R.id.mv_votCount)
        var language: TextView = findViewById(R.id.mv_language)
        var posterImage: ImageView = findViewById(R.id.mv_poster)
        var smallPoster: ImageView = findViewById(R.id.mv_imageView)
        title.text = intent.getStringExtra("title")
        postdate.text = intent.getStringExtra("postDate")
        overview.text = intent.getStringExtra("overview")
        popularity.text = intent.getStringExtra("popularity")
        votcount.text = intent.getStringExtra("votecount")
        language.text = intent.getStringExtra("language")
        Glide.with(applicationContext).load(intent.getStringExtra("smallimage")).into(smallPoster)
        Glide.with(applicationContext).load(intent.getStringExtra("posterimage")).into(posterImage)
    }
}