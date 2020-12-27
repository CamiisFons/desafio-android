package br.com.desafioandroidcamila.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.adapter.RepositoryAdapter
import br.com.desafioandroidcamila.databinding.ActivityMainBinding
import br.com.desafioandroidcamila.models.Repositories
import br.com.desafioandroidcamila.models.Repository
import br.com.desafioandroidcamila.webservices.InicializadorAPI.init
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val list = ArrayList<Repository>()
    private val adapter = RepositoryAdapter(list)

    private val users by lazy { init() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        val recycler_view = findViewById<RecyclerView>(R.id.recycler_repository)

        recycler_view?.adapter = adapter
        recycler_view?.layoutManager = LinearLayoutManager(this)
        recycler_view?.setHasFixedSize(true)


        users.getRepository().enqueue(object : Callback<Repositories> {
            override fun onResponse(
                call: Call<Repositories>,
                response: Response<Repositories>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        binding.recyclerRepository.adapter =
                            RepositoryAdapter(it.items)
                    }
                }
            }

            override fun onFailure(call: Call<Repositories>, t: Throwable) {
                Log.d("Erro", t.message.toString())
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

}

         //fun onItemClick(position: Int) {
           // val intencao = Intent(this, PullRequestActivity::class.java)
          //  startActivity(intencao)



