package com.example.philipplacknertheessentialsofindustrylevel.data.remote

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener


class WebSocketClient(
    private val okHttpClient: OkHttpClient,
    private val tokenService: TokenService
): WebSocketListener() {

    suspend fun connect() {
        if (tokenService.isTokenValid()) {
            val request = Request.Builder().url("ws://test.com").build()
            okHttpClient.newWebSocket(request, this)
        }
    }

}