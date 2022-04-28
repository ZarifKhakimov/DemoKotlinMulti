package com.example.demokotlin.activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demokotlin.R
import com.example.demokotlin.adapter.RecyclerAdapter
import com.example.demokotlin.model.Member


class RecyclerActivity : AppCompatActivity() {
    private var context: Context? = null
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initViews()
        val members: List<Member> = prepareMemberList()
        refreshAdapter(members)
    }

    fun initViews() {
        recyclerView = findViewById(R.id.recyclerview)
        recyclerView?.setLayoutManager(GridLayoutManager(context, 2))
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = RecyclerAdapter(context, members)
        recyclerView!!.adapter = adapter
    }

    private fun prepareMemberList(): List<Member> {
        val members: MutableList<Member> = ArrayList<Member>()
        for (i in 0..29) {
            if (i == 0 || i == 5 || i == 16 || i == 25) {
                members.add(Member(14 + i, "Zarifjon$i", false))
            } else {
                members.add(Member(14 + i, "Zarifjon$i", true))
            }
        }
        return members
    }
}
