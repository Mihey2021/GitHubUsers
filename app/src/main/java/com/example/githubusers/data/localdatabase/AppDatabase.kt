package com.example.githubusers.data.localdatabase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.githubusers.data.GithubUser

@Database(entities = [GithubUser::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract val userDao: UserDao
}