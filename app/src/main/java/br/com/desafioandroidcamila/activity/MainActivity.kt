package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.adapter.RepositoryAdapter
import br.com.desafioandroidcamila.models.ItemRepository

class MainActivity : AppCompatActivity(),RepositoryAdapter.OnItemClickListener {

    private val itemRepository = generateList(300)
    private val adapter = RepositoryAdapter(itemRepository, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler_repository = findViewById<RecyclerView>(R.id.recycler_repository)


        recycler_repository?.adapter = adapter
        recycler_repository?.layoutManager = LinearLayoutManager(this)
        recycler_repository?.setHasFixedSize(true)


    }

    override fun onItemClick(position: Int) {
        val intencao = Intent(this, PullRequestActivity::class.java)
        startActivity(intencao)
    }

    private fun generateList(size: Int): List<ItemRepository> {
        val list = ArrayList<ItemRepository>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_person
                else -> R.drawable.ic_person
            }
            val item = ItemRepository(
                drawable,
                "Camis $i",
                "Camis Bucks",
                "5648",
                "486",
                "Passando Perrengue",
                "No dia que eu passei um perrengue danado tentando implementar um recycler view e consumir API",
                7,
                1
            )
            list += item
        }
        return list
    }
}

