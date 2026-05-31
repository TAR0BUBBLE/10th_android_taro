package com.example.week03_taro

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://reqres.in/"

private const val REQRES_API_KEY = "reqres_700acc063f314d19b74f08911afa5ae6"

class ReqresApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        val newRequest = chain.request()
            .newBuilder()
            .addHeader("x-api-key", REQRES_API_KEY)
            .build()

        return chain.proceed(newRequest)
    }
}

object ReqresApiClient {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ReqresApiKeyInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()

    val service: ReqresService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ReqresService::class.java)
    }
}