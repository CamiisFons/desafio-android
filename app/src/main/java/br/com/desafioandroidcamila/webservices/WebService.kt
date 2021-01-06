package br.com.desafioandroidcamila.webservices

import br.com.desafioandroidcamila.models.PullRequest
import br.com.desafioandroidcamila.models.Repositories
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

class WebService {

    interface RepositoryInterface {
        @GET("search/repositories?q=language:Java&sort=stars")
        fun getList(@Query("page") page: Int): Call<Repositories>

    }

    interface PullRequestInterface {
        @GET("repos/{owner}/{repositories}/pulls")

        fun getPullRequest(
            @Path("owner") owner: String,
            @Path("repositories") repositories: String,
        ): Call<List<PullRequest>>
    }
}




