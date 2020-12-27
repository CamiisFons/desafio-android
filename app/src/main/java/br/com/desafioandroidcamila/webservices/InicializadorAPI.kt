package br.com.desafioandroidcamila.webservices

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InicializadorAPI {
    fun init ():RepositoryInterface{
       return Retrofit.Builder()
          .baseUrl("https://api.github.com")
          .addConverterFactory(GsonConverterFactory.create())
          .build()
          .create(RepositoryInterface::class.java)
    }
}