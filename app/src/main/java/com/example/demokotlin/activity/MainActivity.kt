package com.example.demokotlin.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.demokotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
        val button = findViewById<Button>(R.id.b_click)
    button.setOnClickListener({
        openNext()
    })
    }

    fun openNext(){
        val intent = Intent(this, RecyclerActivity::class.java)
        startActivity(intent)
    }
}