package com.example.searchmovieapp.domain.model

import com.example.searchmovieapp.domain.base.BaseBusinessModel

data class CarouselItemBM(
    val movieGenre: String? = null,
    val movieGenreImage: String? = null
) : BaseBusinessModel()