package com.example.pembekalan_siakadstechoq.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface MyAPI {

    @GET("photos")
    fun getPhotos(): Call<List<Photos>>
}