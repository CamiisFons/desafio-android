package br.com.desafioandroidcamila.models

data class ItemPullRequest (
            val photo_user: Int,
            val pull_request_username: String,
            val pull_request_title: String,
            val pull_request_name: String,
            val pull_request_description: String,
            val pull_request_date: String
)