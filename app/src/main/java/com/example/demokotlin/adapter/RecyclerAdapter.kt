package com.example.demokotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.R
import com.example.demokotlin.model.Member


class RecyclerAdapter(private val context: Context?, members: List<Member>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val members: List<Member>


    override fun getItemViewType(position: Int): Int {
        return if (members[position].isAvailable) {
            TYPE_AVAILABLE_YES
        } else TYPE_AVAILABLE_NO
    }

    override fun getItemCount(): Int {
        return members.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == TYPE_AVAILABLE_YES) {
            val view: View = LayoutInflater.from(viewGroup.context)
                .inflate(R.layout.item_member_view_yes, viewGroup, false)
            return CustomViewYesHolder(view)
        }
        val view: View = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_member_view_no, viewGroup, false)
        return CustomViewNotHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val member: Member = members[position]
        if (holder is CustomViewYesHolder) {
            val name = holder.name
            val age = holder.age
            name.setText(member.name)
            age.id = member.age
        }
        if (holder is CustomViewNotHolder) {
            val name = holder.name
            val age = holder.age
            name.text = "Name isn't Available"
            age.text = "Age isn't Available"
        }
    }

    inner class CustomViewYesHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var age: TextView
        var name: TextView

        init {
            name = view.findViewById(R.id.name)
            age = view.findViewById(R.id.age)
        }
    }

    inner class CustomViewNotHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var age: TextView

        init {
            name = view.findViewById(R.id.name)
            age = view.findViewById(R.id.age)
        }
    }

    companion object {
        private const val TYPE_AVAILABLE_YES = 0
        private const val TYPE_AVAILABLE_NO = 1
    }

    init {
        this.members = members
    }
}