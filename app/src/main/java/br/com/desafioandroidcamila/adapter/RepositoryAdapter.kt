package br.com.desafioandroidcamila.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.models.ItemRepository

class RepositoryAdapter(private val repositoryList: List<ItemRepository>, private val listener: OnItemClickListener): RecyclerView.Adapter<RepositoryAdapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.repository_item,parent, false)
                return ItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = repositoryList[position]

        holder.username.text = currentItem.username
        holder.authorName.text = currentItem.author_name
        holder.starQnty.toString()
        holder.forkQnty.toString()
        holder.repository_name.text = currentItem.repository_name
        holder.description_repository.text = currentItem.description_repository
        holder.photo_user.setImageResource(currentItem.photo_user)

    }

    override fun getItemCount() = repositoryList.size

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener {

        val username : TextView = itemView.findViewById(R.id.username)
        val authorName : TextView = itemView.findViewById(R.id.author_name)
        val starQnty : TextView = itemView.findViewById(R.id.star_qnty)
        val forkQnty : TextView = itemView.findViewById(R.id.fork_qnty)
        val repository_name: TextView = itemView.findViewById(R.id.repository_name)
        val description_repository: TextView = itemView.findViewById(R.id.description_repository)
        val photo_user : ImageView = itemView.findViewById(R.id.photo_user)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION)
            listener.onItemClick(position)
        }
    }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }
}
