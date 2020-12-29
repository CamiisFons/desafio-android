package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.desafioandroidcamila.Utils.Constants
import br.com.desafioandroidcamila.adapter.PullRequestAdapter
import br.com.desafioandroidcamila.databinding.ActivityPullRequestBinding
import br.com.desafioandroidcamila.models.PullRequest
import br.com.desafioandroidcamila.webservices.InicializadorAPI.initPull
import kotlinx.android.synthetic.main.pull_request_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullRequestActivity : AppCompatActivity(),PullRequestAdapter.ListOnClickListener{

    private val listPull = ArrayList<PullRequest>()
    private val adapter = PullRequestAdapter(listPull,this)

    private lateinit var bindingPull : ActivityPullRequestBinding

    var owner = ""
    var repositories = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingPull = ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        owner = intent.getStringExtra(Constants.owner).toString()
        repositories = intent.getStringExtra(Constants.repositories).toString()

        setSupportActionBar(bindingPull.toolBar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bindingPull.toolBar2.title = repositories

        bindingPull.pullRecycler.adapter = adapter
        bindingPull.pullRecycler.layoutManager = LinearLayoutManager(this)
        bindingPull.pullRecycler.setHasFixedSize(true)



        getPullRequest(owner,repositories)
    }

        fun getPullRequest (owner: String,repositories: String){
        val Api = initPull()

        val call = Api.getPullRequest(owner,repositories)

        call.enqueue(object : Callback<List<PullRequest>> {
            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                Log.d("Erro de chamada", t.message.toString())
                Toast.makeText(this@PullRequestActivity, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<PullRequest>>, response: Response<List<PullRequest>>) {
                if (response.isSuccessful){
                    response.body()?.let {
                        bindingPull.pullRecycler.adapter = PullRequestAdapter(listPull,this@PullRequestActivity)
                        listPull.addAll(it)
                    }
                }
            }

        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return false
    }

    override fun OnItemListClick(position: Int) {
        val url = listPull[position].html_url
        val intencaoPull= Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intencaoPull)
    }


}




