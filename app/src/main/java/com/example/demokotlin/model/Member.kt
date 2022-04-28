package com.example.demokotlin.model

class Member(var age: Int, var name: String, available: Boolean) {
    var isAvailable = false

    init {
        isAvailable = available
    }
}
