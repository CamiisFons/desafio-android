package br.com.desafioandroidcamila.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.desafioandroidcamila.models.Repository
import br.com.desafioandroidcamila.repositorio.RepoRepository
import kotlinx.coroutines.launch

class RepositoryViewModel (private val re: RepoRepository): ViewModel() {

    private val repositoryList: MutableLiveData<List<Repository>> = MutableLiveData()
    private val excecao: MutableLiveData<String> = MutableLiveData()

    fun listRepository(pagina: Int) {
        viewModelScope.launch {
            val response = re.searchRepository(pagina)
            if (response.isSuccessful) {
                repositoryList.postValue(response.body())
            } else {
                excecao.postValue("problem!")
            }

        }
    }
}

