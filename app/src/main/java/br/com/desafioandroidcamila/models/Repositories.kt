package br.com.desafioandroidcamila.models

import com.google.gson.annotations.SerializedName

class Repositories (
    @SerializedName("items") val items: List<Repository >
        )
