package com.example.searchmovieapp.data.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.searchmovieapp.data.model.CarouselItemRM
import com.example.searchmovieapp.data.model.MovieItemRM
import com.example.searchmovieapp.domain.model.MovieUseCaseRequest
import com.example.searchmovieapp.presentation.utils.ResponseWrapper
import com.example.searchmovieapp.data.base.BaseLocalDao

class MovieLocalDao : BaseLocalDao() {


    fun getMovieGenreList(): LiveData<ResponseWrapper<List<CarouselItemRM>>> {
        val liveData: MutableLiveData<ResponseWrapper<List<CarouselItemRM>>> =
            MutableLiveData<ResponseWrapper<List<CarouselItemRM>>>()
        val overviewList: MutableList<CarouselItemRM> = getGenreList()
        liveData.value = ResponseWrapper.success(overviewList)

        return liveData
    }


    fun getMovieList(req: MovieUseCaseRequest): LiveData<ResponseWrapper<List<MovieItemRM>>> {
        val liveData: MutableLiveData<ResponseWrapper<List<MovieItemRM>>> =
            MutableLiveData<ResponseWrapper<List<MovieItemRM>>>()

        val overviewList: MutableList<MovieItemRM> = when (req.movieGenreId) {
            0 -> getActionMovieList()
            1 -> getAdventureMovieList()
            2 -> getAnimationMovieList()
            3 -> getDramaMovieList()
            4 -> getFantasyMovieList()
            5 -> getHorrorMovieList()
            6 -> getSciFiMovieList()
            else -> {
                ArrayList()
            }
        }
        liveData.value = ResponseWrapper.success(overviewList)
        return liveData
    }
}