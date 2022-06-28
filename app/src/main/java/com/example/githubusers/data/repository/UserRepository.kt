package com.example.githubusers.data.repository

import com.example.githubusers.data.api.UserApi
import com.example.githubusers.data.localdatabase.UserDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository(private val userApi: UserApi, private val userDao: UserDao) {
    val data = userDao.findAll()

    suspend fun refresh(){
        withContext(Dispatchers.IO) {
            val users = userApi.getAllAsync()
            userDao.add(users)
        }
    }
}