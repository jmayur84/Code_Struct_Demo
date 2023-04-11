package com.example.searchmovieapp.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.searchmovieapp.databinding.ItemHomeMovieBinding
import com.example.searchmovieapp.presentation.utils.ImageUtil
import com.example.searchmovieapp.domain.model.MovieItemBM

class MovieListAdapter(val ls: ArrayList<MovieItemBM>, var mListener: (MovieItemBM) -> Unit) :
    RecyclerView.Adapter<MovieListAdapter.MovieListViewHolder>(), Filterable {

    private var movieList = ls
    private var filterList = ls

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieListViewHolder {
        val mView =
            ItemHomeMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieListViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return filterList.size
    }

    override fun onBindViewHolder(holder: MovieListViewHolder, position: Int) {
        holder.bindData(filterList[position])
        holder.itemView.setOnClickListener { mListener(ls[position]) }
    }

    fun getMovieList(): List<MovieItemBM> {
        return filterList
    }

    class MovieListViewHolder(itemView: ItemHomeMovieBinding) :
        RecyclerView.ViewHolder(itemView.root) {

        private val binding = itemView

        fun bindData(movieItemBM: MovieItemBM) {
            binding.imgMovie.setImageResource(
                ImageUtil.getImageIdFromName(
                    context = itemView.context,
                    movieItemBM.movieImage!!
                )
            )
            binding.tvMovieName.text = movieItemBM.movieName
            binding.tvMovieDesc.text = movieItemBM.movieDesc
        }
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charString = constraint.toString()
                if (charString.isEmpty()) {
                    filterList = movieList
                } else {
                    val fList:ArrayList<MovieItemBM> = ArrayList()
                    movieList.forEach {
                        if (it.movieName!!.lowercase().contains(charString.lowercase())) {
                            fList.add(it)
                        }
                    }
                    filterList = fList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results!!.values as ArrayList<MovieItemBM>
                notifyDataSetChanged()
            }
        }
    }


}