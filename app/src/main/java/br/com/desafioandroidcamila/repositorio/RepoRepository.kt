package br.com.desafioandroidcamila.repositorio

import br.com.desafioandroidcamila.models.Repository
import retrofit2.Response

class RepoRepository(private val ItemRepository: RepoRepository) {
    fun searchRepository(page: Int):Response<List<Repository>> {
        return ItemRepository.searchRepository(page)
    }
}