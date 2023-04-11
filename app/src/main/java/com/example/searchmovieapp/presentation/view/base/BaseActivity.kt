package com.example.searchmovieapp.presentation.view.base

import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<out VB : ViewBinding> : AppCompatActivity() {


    abstract fun initView()
    private var binding: VB? = null

    protected open fun initState(savedInstanceState: Bundle?) {}

    protected open fun getBinding(): VB {
        return binding!!
    }

    abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setup(savedInstanceState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setup(savedInstanceState)
    }

    private fun setup(savedInstanceState: Bundle?) {
        binding = inflateLayout(layoutInflater)
        setContentView(binding?.root)
        initState(savedInstanceState)
        initView()
    }

    fun showBottomToastMessage(
        message: String,
        view: View
    ) {
        Snackbar.make(view, message, BaseTransientBottomBar.LENGTH_SHORT).show()
    }
}