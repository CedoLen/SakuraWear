package com.example.sakurawear.Network

data class login(val id:Int, val email:String, val nickName:String, val avatar: String, val token: String)
data class feelings(val success:Boolean, val data:List<feel>)

data class feel(val id:Int, val title:String, val image:String, val position:Int)
