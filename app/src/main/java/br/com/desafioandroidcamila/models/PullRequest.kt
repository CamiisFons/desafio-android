package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName

data class PullRequest(
    @SerializedName("")
    val pullRequestTytle : String,
    @SerializedName("")
    val pullDescription : String,
    @SerializedName ("full_name")
    val pullRequestName: String,
    val owner: Owner,

)
