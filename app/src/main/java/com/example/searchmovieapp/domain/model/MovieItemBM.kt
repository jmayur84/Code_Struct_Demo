package com.example.searchmovieapp.domain.model

import com.example.searchmovieapp.domain.base.BaseBusinessModel

data class MovieItemBM(
    val movieName: String? = null,
    val movieDesc: String? = null,
    val movieImage: String? = null
) : BaseBusinessModel()