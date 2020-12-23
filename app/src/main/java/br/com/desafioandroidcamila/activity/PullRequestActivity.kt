package br.com.desafioandroidcamila.activity

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.adapter.PullRequestAdapter
import br.com.desafioandroidcamila.databinding.ActivityPullRequestBinding
import br.com.desafioandroidcamila.models.PullRequestRepository

class PullRequestActivity : AppCompatActivity() {

    val pullRequestList = generateList(300)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindingPull = ActivityPullRequestBinding.inflate(layoutInflater)
        setContentView(bindingPull.root)
        setSupportActionBar(bindingPull.toolBar2)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val pull_recycler = findViewById<RecyclerView>(R.id.pull_recycler)

        pull_recycler?.adapter = PullRequestAdapter(pullRequestList)
        pull_recycler?.layoutManager = LinearLayoutManager(this)
        pull_recycler?.setHasFixedSize(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            android.R.id.home -> finish()
        }
        return false
    }

    private fun generateList(size: Int): List<PullRequestRepository> {
        val list = ArrayList<PullRequestRepository>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_person
                else -> R.drawable.ic_person
            }
            val item = PullRequestRepository(
                drawable,
                "Cleiton",
                "App legal",
                "Cleiton Maneiro",
                "esse é o melhor app do mundo",
                "2020/28/09"
            )
            list += item
        }
        return list
    }
}
