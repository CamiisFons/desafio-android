package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name")
    val repositoryName: String,
    @SerializedName("description")
    val repositoryDescription: String,
    @SerializedName("forks_count")
    val forksQnty: Int,
    @SerializedName("stargazers_count")
    val starQnty: Int,
    @SerializedName("fullname")
    val login: String,
    @SerializedName("id") val id: Int,
    @SerializedName("owner") val owner: Owner
)
