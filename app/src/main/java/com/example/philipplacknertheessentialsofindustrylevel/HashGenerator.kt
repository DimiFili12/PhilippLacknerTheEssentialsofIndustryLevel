package com.example.philipplacknertheessentialsofindustrylevel

import org.apache.commons.codec.digest.DigestUtils

interface HashGenerator {
    fun generateHash(value: String): String
}

class Sha256HashGenerator: HashGenerator {
    override fun generateHash(value: String): String {
        return DigestUtils.sha256Hex(value)
    }
}

class Sha512HashGenerator: HashGenerator {
    override fun generateHash(value: String): String {
        return DigestUtils.sha512Hex(value)
    }
}

class Md5HashGenerator: HashGenerator {
    override fun generateHash(value: String): String {
        return DigestUtils.md5Hex(value)
    }
}