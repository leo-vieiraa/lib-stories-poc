package com.example.libstoriespoc.ui.adapter

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R
import com.example.libstoriespoc.domain.model.Story
import java.io.Serializable

class UsersAdapter(
    private var listImages : List<Story>, private var activity: Activity) : RecyclerView.Adapter<UsersAdapter.StoriesViewHolder>() {

    private var itemCheck = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false).let {
            StoriesViewHolder(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: StoriesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        listImages[position].apply {
            holder.bind(itemCheck, position, listImages, activity)
            holder.itemView.setOnClickListener {
                itemCheck = position
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = listImages.size


    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(itemCheck: Int, position: Int, model: List<Story>, activity: Activity ) {

            if (itemCheck == position) {
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
                    .load(model[position].thumbnail.x1)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(this)

                setOnClickListener {
                    val intent = Intent(context, activity::class.java)
                    intent.putExtra("storiesList", (model as Serializable))
                    intent.putExtra("storyPosition", position)
                    ContextCompat.startActivity(context, intent, null)
                }
            }
        }
    }
}