package com.example.libstoriespoc.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.libstoriespoc.MainActivity
import com.example.libstoriespoc.R
import com.example.libstoriespoc.view.customviews.CustomStoriesActivity
import com.example.libstoriespoc.view.customviews.HomeStoriesList

class UsersAdapter(private var listImages : List<HomeStoriesList>) : RecyclerView.Adapter<UsersAdapter.StoriesViewHolder>() {

    private var itemCheck = -1

    var click:(()-> Unit)? = null
    var clickStories:(()-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false).let {
            StoriesViewHolder(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: StoriesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        listImages[position].apply {
            holder.bind(itemCheck, position, this, clickStories)
            holder.itemView.setOnClickListener {
                itemCheck = position
                click?.invoke()
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = listImages.size


    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(itemCheck: Int, position: Int, model : HomeStoriesList , clickStories:(()-> Unit)?) {

            if (itemCheck == position) {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.black))
                }
            } else {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.teal_700))
                }
            }

            itemView.findViewById<CardView>(R.id.idOutline).apply {
                //CustomViewStory(posicao, lista).show()

                setOnClickListener{
                    clickStories?.invoke()
                }
            }

            itemView.findViewById<TextView>(R.id.idNameUser)?.apply {

            }

            itemView.findViewById<ImageView>(R.id.imageUser)?.apply {
                Glide.with(context)
                    .load(model.thumbnail.x1)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(this)
            }
        }
    }
}