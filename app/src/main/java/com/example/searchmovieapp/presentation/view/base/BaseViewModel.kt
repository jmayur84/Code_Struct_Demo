package com.example.searchmovieapp.presentation.view.base

import androidx.core.util.Pair
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.searchmovieapp.domain.base.BaseUseCase
import com.example.searchmovieapp.presentation.utils.ResponseWrapper

open class BaseViewModel() : ViewModel() {

    private var useCases: Array<out BaseUseCase<*, *>?>? = null
    private var liveDataObserverPairList: ArrayList<Pair<LiveData<*>, Observer<*>>>? = null


    constructor(vararg useCases: BaseUseCase<*, *>) : this() {
        this.useCases = useCases
    }

    open fun onStart() {}

    protected fun <T> observe(
        liveData: LiveData<ResponseWrapper<T>>,
        observer: Observer<ResponseWrapper<T>>
    ) {
        if (liveDataObserverPairList == null) liveDataObserverPairList = ArrayList()

        liveDataObserverPairList!!.add(Pair(liveData, observer))
        liveData.observeForever(observer)
    }

    override fun onCleared() {
        liveDataObserverPairList?.let { list ->
            for (liveDataObserverPair in list) {
                if (liveDataObserverPair.first == null) continue
                if (liveDataObserverPair.second == null) continue
                liveDataObserverPair.first.removeObserver(liveDataObserverPair.second as Observer<in Any>)
            }
        }

        useCases?.let {
            for (useCase in useCases!!) {
                useCase?.clear()
            }
        }


        super.onCleared()
    }
}