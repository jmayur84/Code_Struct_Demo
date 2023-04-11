package com.example.searchmovieapp.presentation.utils

import android.util.Log

class LogHelper {
    companion object {

        private const val TAG_DATA = "movieAppTag"
        private const val TAG_ERROR = "errorTag"


        fun d(message: String = "") {
            Log.d(TAG_DATA, message)
        }

        fun e(message: String = "") {
            Log.e(TAG_DATA, message)
        }

    }
}