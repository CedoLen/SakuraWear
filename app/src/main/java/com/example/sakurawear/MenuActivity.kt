package com.example.sakurawear

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.RecyclerView
import com.example.sakurawear.Adapters.listAdapter
import com.example.sakurawear.Network.feelings
import com.example.sakurawear.Network.myIterface
import com.example.sakurawear.Network.myRetrofit
import retrofit2.Call
import retrofit2.Response

class MenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val rec = findViewById<RecyclerView>(R.id.myRecy)
        val ret = myRetrofit().getRetrofit()
        val inter = ret.create(myIterface::class.java)
        val call = inter.getFeelengs()
            .enqueue(object : retrofit2.Callback<feelings> {
                override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                    if (response.isSuccessful){
                        listAdapter(this@MenuActivity, response.body()!!).also { rec.adapter = it }
                    }
                }

                override fun onFailure(call: Call<feelings>, t: Throwable) {
                    Toast.makeText(this@MenuActivity, t.localizedMessage,Toast.LENGTH_SHORT).show()
                }

            })
    }
}