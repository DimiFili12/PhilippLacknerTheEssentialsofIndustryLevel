package com.example.philipplacknertheessentialsofindustrylevel.data.remote

import android.content.SharedPreferences

class TokenService(
    private val prefs: SharedPreferences,
    private val myApi: MyApi,
) {

    suspend fun isTokenValid(): Boolean {
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