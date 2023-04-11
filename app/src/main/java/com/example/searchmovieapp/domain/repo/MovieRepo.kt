package com.example.searchmovieapp.domain.repo

import androidx.lifecycle.LiveData
import com.example.searchmovieapp.data.remote.MovieLocalDao
import com.example.searchmovieapp.domain.model.MovieUseCaseRequest
import com.example.searchmovieapp.presentation.utils.ResponseWrapper
import com.example.searchmovieapp.domain.base.BaseRepo
import com.example.searchmovieapp.domain.model.CarouselItemBM
import com.example.searchmovieapp.domain.model.MovieItemBM

class MovieRepo : BaseRepo() {
    private var movieLocalDao: MovieLocalDao = MovieLocalDao()

    fun getMovieGenre(
    ): LiveData<ResponseWrapper<List<CarouselItemBM>>> {
        return parseResponseListResource(movieLocalDao.getMovieGenreList())
    }

    fun getMovieList(
        req: MovieUseCaseRequest
    ): LiveData<ResponseWrapper<List<MovieItemBM>>> {
        return parseResponseListResource(movieLocalDao.getMovieList(req))
    }
}