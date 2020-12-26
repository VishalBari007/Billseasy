package com.vishalbari.billseasy

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.vishalbari.billseasy.models.MoviesDetailsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BottomSheetFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
open class BottomSheetFragment(list: ArrayList<MoviesDetailsModel>, contextMenu: Context,position:Int) : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view:View = inflater.inflate(R.layout.fragment_bottom_sheet, container, false)
        var title:TextView = view.findViewById(R.id.mv_title)
        var postdate:TextView = view.findViewById(R.id.mv_postDate)
        var overview:TextView = view.findViewById(R.id.mv_overview)
        var popularity:TextView = view.findViewById(R.id.mv_popularity)
        var votcount:TextView = view.findViewById(R.id.mv_votCount)
        var language:TextView = view.findViewById(R.id.mv_language)
        var posterImage:ImageView = view.findViewById(R.id.mv_poster)
        var smallPoster:ImageView = view.findViewById(R.id.mv_imageView)



        return view
    }

}