package com.example.searchmovieapp.domain.usecase

import androidx.lifecycle.MutableLiveData
import com.example.searchmovieapp.domain.model.MovieUseCaseRequest
import com.example.searchmovieapp.domain.repo.MovieRepo
import com.example.searchmovieapp.presentation.utils.ResponseWrapper
import com.example.searchmovieapp.presentation.utils.Status
import com.example.searchmovieapp.domain.base.BaseUseCase
import com.example.searchmovieapp.domain.model.CarouselItemBM

class MovieGenreUseCase : BaseUseCase<MovieUseCaseRequest, List<CarouselItemBM>>() {
    private var movieRepo: MovieRepo = MovieRepo()

    override fun process(
        req: MovieUseCaseRequest,
        resultLiveData: MutableLiveData<ResponseWrapper<List<CarouselItemBM>>>?
    ) {
        observe(movieRepo.getMovieGenre()) { resource ->
            when (resource.getResStatus()) {
                Status.SUCCESS -> {
                    if (resource.getResData() != null) {
                        resultLiveData?.value = ResponseWrapper.success(resource.getResData()!!)
                    }
                }
                Status.ERROR -> resultLiveData?.value =
                    ResponseWrapper.error(null, resource.getResError())
                Status.LOADING -> resultLiveData?.value = ResponseWrapper.loading()
            }
        }
    }

}