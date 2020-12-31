package br.com.desafioandroidcamila.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.Utils.Constants
import br.com.desafioandroidcamila.adapter.RepositoryAdapter
import br.com.desafioandroidcamila.databinding.ActivityMainBinding
import br.com.desafioandroidcamila.viewmodel.RepositoryViewModel

class RepositoryActivity : AppCompatActivity(), RepositoryAdapter.OnItemClickListener {


    private val adapterRepository = RepositoryAdapter(ArrayList(),this)

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewModel: RepositoryViewModel
    private var page = 1
    private var isLoading = false
    private var lastPosition = 0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerInit()

    }
        fun recyclerInit() {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            binding.recyclerRepository.adapter = adapterRepository
            binding.recyclerRepository.layoutManager = LinearLayoutManager(this)
            binding.recyclerRepository.setHasFixedSize(true)
            setSupportActionBar(binding.toolBar)
            getRepository(page)


            binding.recyclerRepository.addOnScrollListener(object : RecyclerView.OnScrollListener(){
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)
                    val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                    val lastCompleteItem = layoutManager.findLastCompletelyVisibleItemPosition()
                    if (!isLoading){
                        if (lastCompleteItem == adapterRepository.repositoryList.size - 1){
                            page +=1
                            isLoading = true
                            lastPosition = adapterRepository.repositoryList.size +1
                            getRepository(++page)
                        }
                    }
                }
            })
                }




        private fun getRepository(page: Int){

            viewModel = ViewModelProvider(this).get(RepositoryViewModel::class.java)
            viewModel.liveData.observe(this, {
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




