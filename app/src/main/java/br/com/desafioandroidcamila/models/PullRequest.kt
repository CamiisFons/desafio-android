package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName


data class PullRequest(
    @SerializedName("title") val pullRequestTitle : String,
    @SerializedName("created_at") val pullRequestDate : String,
    @SerializedName("user") val owner: Owner,
    @SerializedName("html_url") val html_url : String,
    @SerializedName("body") val body : String,
    @SerializedName("login") val name: String,
    @SerializedName("open_issues") val open: String,
    @SerializedName("number") val number : String

)
