package br.com.desafioandroidcamila.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.desafioandroidcamila.models.PullRequest
import br.com.desafioandroidcamila.webservices.InicializadorAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestViewModel : ViewModel() {

    val liveDataPull: MutableLiveData<List<PullRequest>> = MutableLiveData()
    val liveDataPullError = MutableLiveData<Any>()


    fun getPull(owner: String, repositories: String) {

        val usersPull by lazy { InicializadorAPI.initPull() }
        val call = usersPull.getPullRequest(owner, repositories)

        call.enqueue(object : Callback<List<PullRequest>> {
            override fun onResponse(
                call: Call<List<PullRequest>>,
                response: Response<List<PullRequest>>,
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        liveDataPull.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                Log.d("Erro de chamada", t.message.toString())
                liveDataPullError.postValue(t)
            }

        }
        )


    }
}
