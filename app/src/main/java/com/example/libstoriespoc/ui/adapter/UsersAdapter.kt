package com.example.libstoriespoc.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R
import com.example.libstoriespoc.domain.model.Story
import com.example.libstoriespoc.ui.MainActivity
import com.example.libstoriespoc.ui.customviews.CustomRecyclerView
import java.io.Serializable

class UsersAdapter(private var activity: Activity) :
    ListAdapter<Story, UsersAdapter.StoriesViewHolder>(StoriesDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false).let {
            StoriesViewHolder(it)
        }
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        getItem(position).let {
            holder.bind(position, currentList, activity)
        }
    }

    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int, storiesList: List<Story>, activity: Activity ) {

            if (storiesList[position].viewed) {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.black))
                }
            } else {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.teal_700))
                }
            }

            itemView.findViewById<ImageView>(R.id.imageUser)?.apply {
                Glide.with(context)
                    .load(storiesList[position].thumbnail.x1)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(this)

                setOnClickListener {
                    checkStories(storiesList[position])
                    val intent = Intent(context, activity::class.java)
                    intent.putExtra("storiesList", (storiesList as Serializable))
                    intent.putExtra("storyPosition", position)
//                    possível futura implementacao
//                    intent.putExtra("itemView", itemView as Serializable)
                    ContextCompat.startActivity(context, intent, null)

                }
            }
        }

        fun checkStories(story: Story) {
            if (story.viewed) {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.black))
                }
            } else {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.teal_700))
                }
            }
        }
    }
}