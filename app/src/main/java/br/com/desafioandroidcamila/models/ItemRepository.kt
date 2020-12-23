package br.com.desafioandroidcamila.models

data class ItemRepository(
        val photo_user: Int,
        val username: String,
        val author_name: String,
        val star_qnty: String,
        val fork_qnty: String,
        val repository_name: String,
        val description_repository: String,
        val star: Int,
        val fork: Int
)
