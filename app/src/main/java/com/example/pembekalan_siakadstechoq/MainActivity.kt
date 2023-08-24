package com.example.pembekalan_siakadstechoq

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.pembekalan_siakadstechoq.retrofit.MyAPI
import com.example.pembekalan_siakadstechoq.retrofit.Photos
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val BASE_URL="https://jsonplaceholder.typicode.com/photos"
    private val TAG: String = "CHECK_RESPONSE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getAllPictures()
    }

    private fun getAllPictures(){
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        api.getPhotos().enqueue(object:Callback<List<Photos>>{
            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        for (photo in it){
                            Log.i(TAG, "onResponse: ${photo.url}")
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {
                Log.i(TAG, "onFailure: ${t.message}")
            }

        })

    }
}