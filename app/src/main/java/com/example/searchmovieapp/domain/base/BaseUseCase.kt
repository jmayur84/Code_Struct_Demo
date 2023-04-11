package com.example.searchmovieapp.domain.base

import androidx.core.util.Pair
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import com.example.searchmovieapp.presentation.utils.ResponseWrapper
import com.example.searchmovieapp.presentation.utils.Status

abstract class BaseUseCase<REQ, RES> {

    private var request: REQ? = null

    private var liveDataObserverPairList: ArrayList<Pair<LiveData<*>, Observer<*>>>? = null


    private var resultLiveData: LiveData<ResponseWrapper<RES>>? = null

    private val resultMutableLiveData: MutableLiveData<ResponseWrapper<RES>> =
        MutableLiveData<ResponseWrapper<RES>>()

    init {
        this.resultLiveData = Transformations.map(
            resultMutableLiveData
        ) { result ->
            when (result.getResStatus()) {
                Status.SUCCESS -> onSuccess(request!!, result.getResData()!!)
                Status.ERROR -> onError(request!!, result.getResError())
                Status.LOADING -> {}
            }
            result
        }
    }

    fun clear() {
        if (liveDataObserverPairList != null) {
            for (liveDataObserverPair in liveDataObserverPairList!!) {
                if (liveDataObserverPair.first == null) continue
                if (liveDataObserverPair.second == null) continue
                liveDataObserverPair.first!!.removeObserver(liveDataObserverPair.second as Observer<in Any>)
            }
        }
    }

    open fun getResultLiveData(): LiveData<ResponseWrapper<RES>> {
        return resultLiveData!!
    }

    open fun getRequest(): REQ {
        return request!!
    }

    open fun setRequest(request: REQ) {
        this.request = request
    }

    protected fun onSuccess(req: REQ, result: RES) {}

    protected fun onError(req: REQ, error: Throwable?) {}

    protected abstract fun process(
        req: REQ,
        resultLiveData: MutableLiveData<ResponseWrapper<RES>>?
    )

    protected open fun validate(request: REQ): ResponseWrapper<*> {
        return ResponseWrapper.success(null)
    }

    open fun execute(request: REQ) {
        this.request = request
        val isValidRequest: ResponseWrapper<Boolean?> =
            validate(request) as ResponseWrapper<Boolean?>
        when (isValidRequest.getResStatus()) {
            Status.SUCCESS -> process(request, resultMutableLiveData)
            Status.ERROR -> {
                val error: Throwable = isValidRequest.getResError()!!
                onError(request, error)
                resultMutableLiveData.setValue(ResponseWrapper.error(null, error))
            }
            Status.LOADING -> {}
        }
    }

    protected fun <T> observe(
        liveData: LiveData<ResponseWrapper<T>>,
        observer: Observer<ResponseWrapper<T>>
    ) {
        if (liveDataObserverPairList == null) liveDataObserverPairList = ArrayList()

        liveDataObserverPairList!!.add(Pair(liveData, observer))
        liveData.observeForever(observer)
    }
}