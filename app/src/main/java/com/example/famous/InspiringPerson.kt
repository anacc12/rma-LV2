package com.example.famous

data class InspiringPerson(
    val name: String,
    val born: String,
    val passed: String,
    val description: String,
    val image: String,
    val quotes: MutableList<String> = ArrayList()
) {
}