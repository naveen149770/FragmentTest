package com.nj.test.model

data class Message (
    val quote: String,
    val address: Address? = null,
    val imagePath: String? = null
)