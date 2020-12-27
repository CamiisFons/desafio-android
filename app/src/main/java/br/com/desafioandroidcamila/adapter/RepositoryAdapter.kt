package br.com.desafioandroidcamila.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.databinding.RepositoryItemBinding
import br.com.desafioandroidcamila.models.Repository
import com.bumptech.glide.Glide

class RepositoryAdapter(private val repositoryList: List<Repository>): RecyclerView.Adapter<RepositoryAdapter.RepositoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(RepositoryItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        holder.binding(repositoryList[position])
        //val repository = repositoryList[position]
       // holder.binding(repository)

        //  holder.itemView.setOnClickListener{
        //    listener.onItemClick(position)
    }


    override fun getItemCount(): Int {
        return repositoryList.size
    }


        class RepositoryViewHolder(private val repositoryItemBinding: RepositoryItemBinding) :
        RecyclerView.ViewHolder(repositoryItemBinding.root) {
        fun binding(repository: Repository) {
            repositoryItemBinding.username.text = repository.owner.username
            repositoryItemBinding.login.text = repository.login
            repositoryItemBinding.starQnty.text = repository.starQnty.toString()
            repositoryItemBinding.forkQnty.text = repository.forksQnty.toString()
            repositoryItemBinding.repositoryName.text = repository.repositoryName
            repositoryItemBinding.descriptionRepository.text = repository.repositoryDescription
            Glide.with(repositoryItemBinding.photoUser)
                .load(repository.owner.photo_user)
                .into(repositoryItemBinding.photoUser)


        }

    }

    //interface OnItemClickListener {
      //  fun onItemClick(position: Int)
   // }
}


