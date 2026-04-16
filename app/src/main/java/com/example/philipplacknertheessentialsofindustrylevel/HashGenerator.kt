package com.example.philipplacknertheessentialsofindustrylevel

import org.apache.commons.codec.digest.DigestUtils

class HashGenerator(private val algorithm: String) {

    fun generateHash(value: String): String {
        return when (algorithm) {
            "SHA256" -> DigestUtils.sha256Hex(value)
            "SHA512" -> DigestUtils.sha512Hex(value)
            "MD5" -> DigestUtils.md5Hex(value)
            else -> throw IllegalArgumentException("Unsupported algorithm")
        }
    }
}