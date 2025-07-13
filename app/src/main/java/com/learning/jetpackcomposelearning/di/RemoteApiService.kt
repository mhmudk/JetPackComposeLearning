package com.learning.jetpackcomposelearning.di

import android.util.Log

class RemoteApiService(private val localDB: LocalDB) {
    init {
        Log.d("XYZ ", "Remote Api service")
    }

    fun getLocalDB() = localDB.getName()
}