package com.example.libstoriespoc.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.libstoriespoc.R

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.StoriesViewHolder>() {

    private var listUsersImage = intArrayOf(
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground,
        R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground
    )
    private var itemCheck = -1

    var click:(()-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        return LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false).let {
            StoriesViewHolder(it)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: StoriesViewHolder, @SuppressLint("RecyclerView") position: Int) {
        listUsersImage[position].apply {
            holder.bind(itemCheck, position)
            holder.itemView.setOnClickListener {
                itemCheck = position
                click?.invoke()
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = listUsersImage.size


    class StoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(itemCheck: Int, position: Int) {

            if (itemCheck == position) {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.black))
                }
            } else {
                itemView.findViewById<CardView>(R.id.idOutline).apply {
                    setCardBackgroundColor(context.resources.getColor(R.color.teal_700))
                }
            }

            itemView.findViewById<TextView>(R.id.idNameUser)?.apply {

            }

            itemView.findViewById<ImageView>(R.id.imageUser)?.apply {
                Glide.with(context)
                    .load("")
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(this)
            }
        }
    }
}