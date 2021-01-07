package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.Utils.Constants
import br.com.desafioandroidcamila.adapter.RepositoryAdapter
import br.com.desafioandroidcamila.databinding.ActivityMainBinding
import br.com.desafioandroidcamila.viewmodel.RepositoryViewModel

class RepositoryActivity : AppCompatActivity(), RepositoryAdapter.OnItemClickListener {


    private val adapterRepository = RepositoryAdapter(ArrayList(), this)

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: RepositoryViewModel
    private var page = 1
    private var isLoading = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
        recyclerInit()

    }

    fun recyclerInit() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerRepository.adapter = adapterRepository
        binding.recyclerRepository.layoutManager = LinearLayoutManager(this)
        binding.recyclerRepository.setHasFixedSize(true)
        viewModel.getRepository(page)
        updateList()

    }

    fun updateList() {
        viewModel.liveData.observe(this, {
            for (i in it) {
                if (i !in adapterRepository.repositoryList) {
                    adapterRepository.repositoryList.addAll(it)
                    adapterRepository.notifyDataSetChanged()
                }
                binding.progressbar.visibility = View.GONE
            }

        })
        onScrollListener()
    }

    fun onScrollListener() {
        binding.recyclerRepository.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!isLoading) {
                    page += 1
                    viewModel.getRepository(page++)

                }
            }

        })
        binding.progressbar.visibility = View.VISIBLE
    }


    override fun onItemClick(position: Int) {
        val intecao = Intent(this, PullRequestActivity::class.java)
        intecao.putExtra(Constants.owner, adapterRepository.repositoryList[position].owner.login)
        intecao.putExtra(Constants.repositories,
            adapterRepository.repositoryList[position].repositoryName)
        startActivity(intecao)
    }


    }





