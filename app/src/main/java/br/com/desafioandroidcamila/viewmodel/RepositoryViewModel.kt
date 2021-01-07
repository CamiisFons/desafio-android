package br.com.desafioandroidcamila.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.desafioandroidcamila.models.Repositories
import br.com.desafioandroidcamila.models.Repository
import br.com.desafioandroidcamila.webservices.InicializadorAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoryViewModel : ViewModel() {

    private val users by lazy { InicializadorAPI.init() }
    val liveData: MutableLiveData<List<Repository>> = MutableLiveData()


    fun getRepository(page: Int) {
        users.getList(page).enqueue(object : Callback<Repositories> {
            override fun onResponse(
                call: Call<Repositories>,
                response: Response<Repositories>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveData.postValue(it.items)
                    }
                }
            }

            override fun onFailure(call: Call<Repositories>, t: Throwable) {
                Log.d("Erro", t.message.toString())
            }

        })
    }
}

