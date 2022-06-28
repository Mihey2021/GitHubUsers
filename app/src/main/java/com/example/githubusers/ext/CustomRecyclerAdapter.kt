package com.example.githubusers.ext

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.R
import com.example.githubusers.data.GithubUser
import com.squareup.picasso.Picasso

class CustomRecyclerAdapter(private val names: List<GithubUser>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatarImage: ImageView = itemView.findViewById(R.id.avatarImage)
        val largeTextView: TextView = itemView.findViewById(R.id.textViewLarge)
        val smallTextView: TextView = itemView.findViewById(R.id.textViewSmall)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        //holder.avatarImage.setImageURI(names[position].avatar_url.toUri())
        Picasso.get().load(names[position].avatar_url).into(holder.avatarImage)
        holder.largeTextView.text = with(names[position]) {"${id.toString()}. $login"}
        //"id: ${githubUser.id.toString()}. ${githubUser.login}: ${githubUser.avatar_url}"
        holder.smallTextView.text = names[position].html_url
    }

    override fun getItemCount() = names.size
}