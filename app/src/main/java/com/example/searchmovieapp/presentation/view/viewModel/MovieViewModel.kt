package com.example.searchmovieapp.presentation.view.viewModel

import androidx.lifecycle.MutableLiveData
import com.example.searchmovieapp.domain.model.MovieUseCaseRequest
import com.example.searchmovieapp.domain.usecase.MovieGenreUseCase
import com.example.searchmovieapp.domain.usecase.MovieListUseCase
import com.example.searchmovieapp.presentation.utils.Constants
import com.example.searchmovieapp.presentation.utils.LogHelper
import com.example.searchmovieapp.presentation.utils.Status
import com.example.searchmovieapp.presentation.view.base.BaseViewModel
import com.example.searchmovieapp.domain.model.CarouselItemBM
import com.example.searchmovieapp.domain.model.MovieItemBM

class MovieViewModel(
) : BaseViewModel() {

    private var movieGenreUC: MovieGenreUseCase
    private var movieListUC: MovieListUseCase
    var mLiveMovieGenreData = MutableLiveData<List<CarouselItemBM>>()
    var mLiveMovieListData = MutableLiveData<List<MovieItemBM>>()
    val loadingServices = MutableLiveData<Boolean>()

    init {
        LogHelper.d("${Constants.VIEW_MODEL_TAG}:" + javaClass.simpleName)
        this.movieGenreUC = MovieGenreUseCase()
        this.movieListUC = MovieListUseCase()
    }

    fun getMovieGenre(movieReq: MovieUseCaseRequest) {
        movieGenreUC.execute(movieReq)

        observe(movieGenreUC.getResultLiveData()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    loadingServices.value = false
                    if (resource.getResData() != null) {
                        mLiveMovieGenreData.value = resource.getResData()
                    }
                }
                Status.ERROR -> loadingServices.setValue(false)
                Status.LOADING -> loadingServices.setValue(true)
            }
        }

//        observe(movieRepo.getMovieGenre(movieReq)) { resource ->
//            when (resource.getStatus()) {
//                Status.SUCCESS -> {
//                    if (resource.getData() != null) {
//                        mLiveMovieGenreData?.value = (resource.getData()!!)
//                    }
//                }
//                Status.ERROR -> loadingServices.value = true
//                Status.LOADING -> loadingServices.value = true
//            }
//        }
    }

    fun getMovieListByGenre(movieReq: MovieUseCaseRequest) {
        movieListUC.execute(movieReq)

        observe(movieListUC.getResultLiveData()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    loadingServices.value = false
                    if (resource.getResData() != null) {
                        mLiveMovieListData.value = resource.getResData()
                    }
                }
                Status.ERROR -> loadingServices.setValue(false)
                Status.LOADING -> loadingServices.setValue(true)
            }
        }

    }
}