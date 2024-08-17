package com.example.ahmedretrofitmobs.data

import com.example.ahmedretrofitmobs.data.model.Products
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("products")
        suspend fun getProductsList(): Products

//    @GET("products/{type}")
//    suspend fun getProductsList(
//        @Path("type") type: String,
//        @Query("page") page: Int,
//        @Query("api_key") apiKey: String
//    ): Products

    companion object{
        const val BASE_URL = "https://dummyjson.com/"
    }
}