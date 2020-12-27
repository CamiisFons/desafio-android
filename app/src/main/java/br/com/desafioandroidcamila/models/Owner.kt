package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("login")
    val username : String,
    @SerializedName ("avatar_url")
    val photo_user : String
)
