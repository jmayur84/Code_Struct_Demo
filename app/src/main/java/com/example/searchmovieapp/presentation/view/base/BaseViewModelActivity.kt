package com.example.searchmovieapp.presentation.view.base

import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding

abstract class BaseViewModelActivity<out VB : ViewBinding, out VM : BaseViewModel> :
    BaseActivity<VB>() {

    private var viewModel: VM? = null

    protected abstract fun getViewModelClass(): Class<BaseViewModel>


    protected open fun getViewModel(): VM {
        return viewModel!!
    }

    override fun initView() {
        viewModel = ViewModelProvider(this)[getViewModelClass()] as VM?

    }
}