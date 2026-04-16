package com.example.philipplacknertheessentialsofindustrylevel

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocketListener

abstract class WebClient {
    abstract fun connectToSocket(url: String)
    abstract fun get(url: String)
}

class HttpWebClient(
    private val okHttpClient: OkHttpClient
): WebClient() {
    override fun connectToSocket(url: String) {
        TODO("Not yet implemented")
    }

    override fun get(url: String) {
        val request = Request.Builder()
            .method("GET", null)
            .url(url)
            .build()
        okHttpClient.newCall(request).execute()
    }
}

class WebSocketClient(
    private val okHttpClient: OkHttpClient
): WebClient() {
    override fun connectToSocket(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()
        okHttpClient.newWebSocket(request, object : WebSocketListener() {})
    }

    override fun get(url: String) {
        TODO("Not yet implemented")
    }

}