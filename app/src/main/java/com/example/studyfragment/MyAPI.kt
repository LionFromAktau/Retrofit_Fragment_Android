package com.example.studyfragment

import retrofit2.Call
import retrofit2.http.GET


interface MyAPI {
    @GET("comments")
    fun getCommments(): Call<List<Comments>>
}