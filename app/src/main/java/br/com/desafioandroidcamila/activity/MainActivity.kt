package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.desafioandroidcamila.Utils.Constants
import br.com.desafioandroidcamila.adapter.RepositoryAdapter
import br.com.desafioandroidcamila.databinding.ActivityMainBinding
import br.com.desafioandroidcamila.viewmodel.RepositoryViewModel

class MainActivity : AppCompatActivity(), RepositoryAdapter.OnItemClickListener {


    private val adapterRepository = RepositoryAdapter(ArrayList(),this)

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: RepositoryViewModel
    private var page = 1

   // private val user by lazy { init() }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerInit()

    }
        private fun recyclerInit() {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.recyclerRepository.adapter = adapterRepository
            binding.recyclerRepository.layoutManager = LinearLayoutManager(this)
            binding.recyclerRepository.setHasFixedSize(true)
            setSupportActionBar(binding.toolBar)
            getRepository(page)

        }

        private fun getRepository(page: Int){

            viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
            viewModel.liveData.observe(this, Observer {
                adapterRepository.repositoryList.addAll(it)
                adapterRepository.notifyDataSetChanged()
            })
            viewModel.getRepository(page)
        }



    override fun onItemClick(position: Int) {
        val intecao = Intent (this, PullRequestActivity::class.java)
        intecao.putExtra(Constants.owner,adapterRepository.repositoryList[position].owner.login)
        intecao.putExtra(Constants.repositories,adapterRepository.repositoryList[position].repositoryName)
        startActivity(intecao)
    }

}




