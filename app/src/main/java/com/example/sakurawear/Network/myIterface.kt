package com.example.sakurawear.Network

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface myIterface {
    @POST("user/login")
    fun postLogin(@Body hashMap: HashMap<String,String>):Call<login>
    @GET("feelengs")
    fun getFeelengs():Call<feelings>
}