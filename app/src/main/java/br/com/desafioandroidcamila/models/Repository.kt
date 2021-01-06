package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("total_count") val totalPage: Int,
    @SerializedName("name") val repositoryName: String,
    @SerializedName("description") val repositoryDescription: String,
    @SerializedName("forks_count") val forksQnty: Int,
    @SerializedName("stargazers_count") val starQnty: Int,
    @SerializedName("full_name") val fullname: String,
    @SerializedName("owner") val owner: Owner
)
