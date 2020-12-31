package br.com.desafioandroidcamila.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.R
import br.com.desafioandroidcamila.models.PullRequest
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.pull_request_item.view.*



class PullRequestAdapter(private val pullRequestList: List<PullRequest>,
                         private val listenerPull : ListOnClickListener
                         ): RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        return PullRequestViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.pull_request_item, parent, false))
    }


    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.titlePull.text = pullRequestList[position].pullRequestTytle
        holder.descriptionPull.text = pullRequestList[position].body
        holder.usernamePull.text = pullRequestList[position].owner.login
        holder.namePull.text = pullRequestList[position].name
        holder.datePull.text = pullRequestList[position].pullRequestDate
        holder.profileImageLoad(pullRequestList[position].owner.photo_user)
        holder.itemView.setOnClickListener {
            listenerPull.OnItemListClick(position)
        }
    }

    override fun getItemCount() = pullRequestList.size


    class PullRequestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titlePull = itemView.pull_title
        val descriptionPull = itemView.pull_description
        val usernamePull = itemView.pull_username
        val namePull = itemView.pull_name
        val datePull = itemView.pull_date
        val photopull = itemView.photo_user

        fun profileImageLoad(url: String) {
            if (url.isBlank()) {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_person)
                    .error(R.drawable.ic_person)
                    .into(photopull)
            }else {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.ic_person)
                    .error(R.drawable.ic_person)
                    .into(photopull)

            }

        }

    }

    interface   ListOnClickListener {
        fun OnItemListClick(position: Int)

    }

}







