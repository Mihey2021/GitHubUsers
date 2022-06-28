package com.example.githubusers.data.api

import com.example.githubusers.data.GithubUser
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface UserApi {
    @GET("users")
    suspend fun getAllAsync(): List<GithubUser>
}