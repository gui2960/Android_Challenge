package com.example.tacom.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tacom.R
import com.example.tacom.model.User
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UserAdapter(userObjectList: List<User>) :
    RecyclerView.Adapter<UserAdapter.CustomViewHolder>() {
    private val userObject: List<User> = userObjectList
    private val userObjectFull: List<User>

    inner class CustomViewHolder(mView: View) :
        ViewHolder(mView) {
        var textViewResource: TextView = mView.findViewById(R.id.textViewRecyclerName)
        var textViewUpdated: TextView = mView.findViewById(R.id.textViewRecyclerName2)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view: View = layoutInflater.inflate(R.layout.recycler_view_user, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.textViewResource.text = userObject[position].firstName
        holder.textViewUpdated.text = userObject[position].lastName
    }

    override fun getItemCount(): Int {
        return userObject.size
    }

    init {
        userObjectFull = ArrayList(userObject)
    }
}