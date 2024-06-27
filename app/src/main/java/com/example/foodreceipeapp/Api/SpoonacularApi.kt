package com.example.foodreceipeapp.Api

import com.example.foodreceipeapp.Model.Receipe
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularApi {

    @GET("recipes/complexSearch")
    fun searchRecipes(
        @Query("apiKey") apiKey: String?,
        @Query("query") query: String?,
        @Query("number") number: Int
    ): Call<Receipe?>?
}