package com.example.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusers.ext.CustomRecyclerAdapter
import com.example.githubusers.ext.LoadingState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        userViewModel.data.observe(this, Observer {
            recyclerView.adapter = CustomRecyclerAdapter(it)
            it.forEach { githubUser ->
                Log.d("MSG", "id: ${githubUser.id.toString()}. ${githubUser.login}: ${githubUser.avatar_url}")
//                Toast.makeText(
//                    baseContext,
//                    "id: ${githubUser.id.toString()}. ${githubUser.login}: ${githubUser.avatar_url}",
//                    Toast.LENGTH_SHORT
//                ).show()
            }
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(
                    baseContext,
                    it.msg,
                    Toast.LENGTH_SHORT
                ).show()
                LoadingState.Status.RUNNING -> Toast.makeText(
                    baseContext,
                    "Loading...",
                    Toast.LENGTH_SHORT
                ).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(
                    baseContext,
                    "Success!",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })

    }
}