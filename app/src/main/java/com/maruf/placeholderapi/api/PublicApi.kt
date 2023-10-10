package com.maruf.placeholderapi.api


import com.maruf.placeholderapi.data.network.ResponsePost
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PublicApi {
    @GET("/posts")
    suspend fun getPost(): Response<ResponsePost>

}

object RetrofitHelper {

    private const val baseUrl = "https://jsonplaceholder.typicode.com/"

    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            // we need to add converter factory to
            // convert JSON object to Java object
            .build()
    }
}