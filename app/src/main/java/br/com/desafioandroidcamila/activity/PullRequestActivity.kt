package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.desafioandroidcamila.Utils.Constants
import br.com.desafioandroidcamila.adapter.PullRequestAdapter
import br.com.desafioandroidcamila.databinding.ActivityPullRequestBinding
import br.com.desafioandroidcamila.viewmodel.PullRequestViewModel

class PullRequestActivity : AppCompatActivity(), PullRequestAdapter.ListOnClickListener {

    private val adapterPull = PullRequestAdapter(ArrayList(), this)

    private lateinit var bindingPull: ActivityPullRequestBinding
    private lateinit var pullViewModel: PullRequestViewModel

    var owner = ""
    var repositories = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pullViewModel = ViewModelProvider(this).get(PullRequestViewModel::class.java)
        recyclerPullInit()
        updatePull()
    }


    fun recyclerPullInit() {
        bindingPull = ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)

        owner = intent.getStringExtra(Constants.owner).toString()
        repositories = intent.getStringExtra(Constants.repositories).toString()

        setSupportActionBar(bindingPull.toolBar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        bindingPull.toolBar2.title = repositories

        bindingPull.pullRecycler.adapter = adapterPull
        bindingPull.pullRecycler.layoutManager = LinearLayoutManager(this)
        bindingPull.pullRecycler.setHasFixedSize(true)


        pullViewModel.getPull(owner, repositories)
    }

    fun updatePull() {
        pullViewModel.liveDataPull.observe(this, {
            adapterPull.pullRequestList.addAll(it)
            adapterPull.notifyDataSetChanged()

        })
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }
        return false
    }

    override fun OnItemListClick(position: Int) {
        val url = adapterPull.pullRequestList[position].html_url
        val intencaoPull = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intencaoPull)
    }
}













