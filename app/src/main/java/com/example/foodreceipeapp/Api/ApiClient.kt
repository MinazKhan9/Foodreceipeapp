package com.example.foodreceipeapp.Api

import android.annotation.SuppressLint
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    private val BASE_URL = "https://api.spoonacular.com/"
    private var instance: ApiClient? = null
    private var api: SpoonacularApi? = null

    @SuppressLint("NotConstructor")
    private fun ApiClient(): ApiClient? {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        api = retrofit.create<SpoonacularApi>(SpoonacularApi::class.java)
        return ApiClient()
    }

    @Synchronized
    fun getInstance(): ApiClient? {
        if (instance == null) {
            instance = ApiClient()
        }
        return instance
    }

    fun getApi(): SpoonacularApi? {
        return api
    }
}