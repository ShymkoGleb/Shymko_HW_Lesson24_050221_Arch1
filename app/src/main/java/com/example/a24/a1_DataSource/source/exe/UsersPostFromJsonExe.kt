package com.example.a24.a1_DataSource.source.exe

import com.example.a24.a1_DataSource.Sourc.Api
import retrofit2.Retrofit

class UsersPostFromJsonExe(private val retrofit: Retrofit) {

    fun getUsersPost()=
    retrofit.create(Api::class.java).getUsersPosts_API().execute().body()
}
