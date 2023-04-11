package com.example.searchmovieapp.presentation.view.base

import com.example.searchmovieapp.domain.base.BaseBusinessModel

interface BaseRepoModel<BBM : BaseBusinessModel> {

    fun <BM : BaseBusinessModel?, RM : BaseRepoModel<BM>?> parseListToBusinessModels(remoteModels: List<RM>?): List<BM> {
        if (remoteModels == null) return ArrayList(0)
        val businessModels: MutableList<BM> = ArrayList()
        for (remoteModel in remoteModels) {
            businessModels.add(remoteModel!!.toBusinessModel())
        }
        return businessModels
    }

    fun toBusinessModel(): BBM
}