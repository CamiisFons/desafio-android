package br.com.desafioandroidcamila.webservices

import br.com.desafioandroidcamila.models.Repositories
import retrofit2.Call
import retrofit2.http.GET

interface RepositoryInterface {
   @GET("search/repositories?q=language:Java&sort=stars&")

   fun getRepository ():Call<Repositories>

}
