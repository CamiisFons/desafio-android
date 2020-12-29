package br.com.desafioandroidcamila.webservices

import br.com.desafioandroidcamila.models.PullRequest
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PullRequestInterface {
    @GET("repos/{owner}/{repositories}/pulls")

    fun getPullRequest(@Path("owner")owner: String,
                        @Path("repositories")repositories: String) : Call<List<PullRequest>>
}