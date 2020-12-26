package com.vishalbari.billseasy.adapters

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.internal.ContextUtils.getActivity
import com.google.gson.Gson
import com.vishalbari.billseasy.BottomSheetFragment
import com.vishalbari.billseasy.MainActivity
import com.vishalbari.billseasy.R
import com.vishalbari.billseasy.models.MoviesDetailsModel
import com.vishalbari.billseasy.models.MoviesModel
import com.vishalbari.billseasy.movieDetailsActivity

class MoviesAdapter(context: Context,list: ArrayList<MoviesDetailsModel>) : RecyclerView.Adapter<MoviesAdapter.MyViewHolder>() {
    var mContext: Context = context;
    var movieList: ArrayList<MoviesDetailsModel> = list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var layoutInflater = LayoutInflater.from(mContext)
        var view = layoutInflater.inflate(R.layout.movies_list_item,parent,false)

        return MyViewHolder(view)
    }
    var bottomSheetFragment: BottomSheetFragment? = null
    private val TAG = "MoviesAdapter"
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.cardView.cardBackgroundColor
        holder.title.text = movieList.get(position).title.toString()
        holder.postDate.text = movieList.get(position).releaseDate.toString()
        holder.popularity.text = movieList.get(position).popularity.toString()
        holder.votCount.text = movieList.get(position).voteCount.toString()
        var urlString = "https://image.tmdb.org/t/p/w500/"+movieList.get(position).posterPath
        Glide.with(mContext).load(urlString).into(holder.image)
        holder.cardView.setOnClickListener(View.OnClickListener {
            val intent = Intent(mContext,movieDetailsActivity::class.java)
            intent.putExtra("title", movieList.get(position).title.toString())
            intent.putExtra("postDate",  movieList.get(position).releaseDate.toString())
            intent.putExtra("popularity", movieList.get(position).popularity.toString())
            intent.putExtra("votecount", movieList.get(position).voteCount.toString())
            var urlString1 = "https://image.tmdb.org/t/p/w500/"+movieList.get(position).backdropPath
            intent.putExtra("posterimage", urlString1)

            intent.putExtra("smallimage",urlString)
            intent.putExtra("overview", movieList.get(position).overview.toString() )
            intent.putExtra("language", movieList.get(position).originalLanguage.toString() )
            mContext.startActivity(intent)
        })

    }

    override fun getItemCount(): Int {
     return movieList.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title:TextView = itemView.findViewById(R.id.title)
        var postDate:TextView = itemView.findViewById(R.id.postDate)
        var image:ImageView = itemView.findViewById(R.id.imageView)
        var popularity:TextView = itemView.findViewById(R.id.popularity)
        var votCount:TextView = itemView.findViewById(R.id.votCount)
        var cardView:CardView = itemView.findViewById(R.id.cardView)

    }

}