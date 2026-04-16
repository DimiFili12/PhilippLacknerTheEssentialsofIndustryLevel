package com.example.philipplacknertheessentialsofindustrylevel.data.remote

import android.content.SharedPreferences
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener


class WebSocketClient(
    private val prefs: SharedPreferences,
    private val okHttpClient: OkHttpClient,
    private val myApi: MyApi
): WebSocketListener() {

    suspend fun connect() {
        if (isTokenValid()) {
            val request = Request.Builder().url("ws://test.com").build()
            okHttpClient.newWebSocket(request, this)
        }
    }

    private suspend fun isTokenValid(): Boolean {
        val savedToken = prefs.getString("token", null)
        if (savedToken == null) {
            val newToken = myApi.login(
                email = prefs.getString("email", null) ?: return false,
                password = prefs.getString("password", null) ?: return false
            )
            return newToken != null
        }
        return myApi.checkIfAuthorized(savedToken)
    }
}