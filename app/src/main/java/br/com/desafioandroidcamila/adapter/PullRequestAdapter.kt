package br.com.desafioandroidcamila.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.models.ItemPullRequest

class PullRequestAdapter(private val pullRequestList: List<ItemPullRequest>): RecyclerView.Adapter<PullRequestAdapter.AdapterPullRequestViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPullRequestViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.pull_request_item,parent, false)
        return PullRequestAdapter.AdapterPullRequestViewHolder(itemView)

    }

    override fun onBindViewHolder(holder:AdapterPullRequestViewHolder, position: Int) {
        val currentItem = pullRequestList[position]

        holder.username.text = currentItem.pull_request_username
        holder.pullRequestName.text = currentItem.pull_request_name
        holder.pullRequestTitle.text = currentItem.pull_request_title
        holder.pullRequestDescription.text = currentItem.pull_request_description
        holder.pullRequestDate.text = currentItem.pull_request_date
        holder.photoUserPull.setImageResource(currentItem.photo_user)

    }

    override fun getItemCount() = pullRequestList.size


    class AdapterPullRequestViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){

        val username : TextView = itemView.findViewById(R.id.pull_request_username)
        val pullRequestName : TextView = itemView.findViewById(R.id.pull_request_name)
        val pullRequestTitle : TextView = itemView.findViewById(R.id.pull_request_title)
        val pullRequestDescription : TextView = itemView.findViewById(R.id.pull_request_description)
        val pullRequestDate : TextView = itemView.findViewById(R.id.pull_request_date)
        val photoUserPull : ImageView = itemView.findViewById(R.id.photo_user)


    }



}

