package com.example.searchmovieapp.data.model

import com.example.searchmovieapp.data.base.BaseRemoteModel
import com.example.searchmovieapp.domain.model.MovieItemBM

data class MovieItemRM(
    val movieName: String? = null,
    val movieDesc: String? = null,
    val movieImage: String? = null
) : BaseRemoteModel<MovieItemBM>() {
    override fun toBusinessModel(): MovieItemBM {
        return MovieItemBM(this.movieName, this.movieDesc, this.movieImage)
    }
}
