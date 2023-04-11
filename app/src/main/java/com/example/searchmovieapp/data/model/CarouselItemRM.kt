package com.example.searchmovieapp.data.model

import com.example.searchmovieapp.data.base.BaseRemoteModel
import com.example.searchmovieapp.domain.model.CarouselItemBM

data class CarouselItemRM(
    val movieGenre: String? = null,
    val movieGenreImage: String? = null
) : BaseRemoteModel<CarouselItemBM>() {
    override fun toBusinessModel(): CarouselItemBM {
        return CarouselItemBM(this.movieGenre, this.movieGenreImage)
    }
}
