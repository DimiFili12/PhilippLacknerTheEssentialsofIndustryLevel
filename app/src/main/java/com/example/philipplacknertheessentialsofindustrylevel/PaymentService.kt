package com.example.philipplacknertheessentialsofindustrylevel

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener

abstract class WebClient

abstract class HttpWebClient: WebClient() {
    abstract fun get(url: String)
}

abstract class WebSocketClient: WebClient() {
    abstract fun connectToSocket(url: String)
}


class HttpWebClientImpl(
    private val okHttpClient: OkHttpClient
): HttpWebClient() {
    override fun get(url: String) {
        val request = Request.Builder()
            .method("GET", null)
            .url(url)
            .build()
        okHttpClient.newCall(request).execute()
    }
}

class WebSocketClientImpl(
    private val okHttpClient: OkHttpClient
): WebSocketClient() {
    override fun connectToSocket(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()
        okHttpClient.newWebSocket(request, object : WebSocketListener() {})
    }
}