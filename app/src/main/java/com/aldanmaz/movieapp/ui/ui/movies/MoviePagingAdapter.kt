package com.aldanmaz.movieapp.ui.ui.movies

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.aldanmaz.movieapp.BR
import com.aldanmaz.movieapp.data.model.Movie
import com.aldanmaz.movieapp.databinding.ViewHolderMovieBinding

class MoviePagingAdapter : PagingDataAdapter<Movie,MoviePagingAdapter.ViewHolder>(DIFF_UTIL) {


    var onClick : ((String) -> Unit)?=null
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.imdbID==newItem.imdbID
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
               return oldItem==newItem
            }

        }
    }

    fun onMovieClick(listener:(String)->Unit){
        onClick= listener
    }
    inner class ViewHolder(val viewDataBinding : ViewHolderMovieBinding) : RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data= getItem(position)

        holder.viewDataBinding.setVariable(BR.movie,data)

        holder.viewDataBinding.root.setOnClickListener {
           onClick?.let {
               it(data?.imdbID!!)
           }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= ViewHolderMovieBinding.inflate(LayoutInflater.from(parent.context),parent,false)
         return ViewHolder(binding)
    }
}