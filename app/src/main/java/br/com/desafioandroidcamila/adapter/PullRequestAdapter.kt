package br.com.desafioandroidcamila.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.desafioandroidcamila.databinding.PullRequestItemBinding
import br.com.desafioandroidcamila.models.PullRequest
import com.bumptech.glide.Glide


class PullRequestAdapter(
    val pullRequestList: MutableList<PullRequest>,
    private val listenerPull: ListOnClickListener,
) : RecyclerView.Adapter<PullRequestAdapter.PullRequestViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PullRequestViewHolder {
        return PullRequestViewHolder(PullRequestItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)
        )
    }


    override fun onBindViewHolder(holder: PullRequestViewHolder, position: Int) {
        holder.bindingPull(this.pullRequestList[position])
        holder.pullRequestItemBinding.cardPull.setOnClickListener {
            listenerPull.OnItemListClick(position)
        }
    }


    override fun getItemCount() = pullRequestList.size


    inner class PullRequestViewHolder(val pullRequestItemBinding: PullRequestItemBinding) :
        RecyclerView.ViewHolder(pullRequestItemBinding.root) {

        fun bindingPull(pullRequest: PullRequest) {

            pullRequestItemBinding.pullTitle.text = pullRequest.pullRequestTitle
            pullRequestItemBinding.pullDescription.text = pullRequest.body
            pullRequestItemBinding.pullUsername.text = pullRequest.owner.login
            pullRequestItemBinding.pullName.text = pullRequest.name
            pullRequestItemBinding.pullDate.text = pullRequest.pullRequestDate
            Glide.with(pullRequestItemBinding.photoUser)
                .load(pullRequest.owner.photo_user)
                .circleCrop()
                .into(pullRequestItemBinding.photoUser)

        }

    }

    interface ListOnClickListener {
        fun OnItemListClick(position: Int)

    }

}







