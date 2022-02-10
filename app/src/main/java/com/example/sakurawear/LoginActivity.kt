package com.example.sakurawear

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.sakurawear.Network.login
import com.example.sakurawear.Network.myIterface
import com.example.sakurawear.Network.myRetrofit
import retrofit2.Call
import retrofit2.Response

class LoginActivity : Activity() {
    lateinit var email: EditText
    lateinit var password:EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        email = findViewById(R.id.editEmail)
        password=findViewById(R.id.editPassword)
    }

    fun clickComeIn(view: View) {
        if (email.text.isNotEmpty() && password.text.isNotEmpty()) {
            val hashMap: HashMap<String, String> = hashMapOf()
            hashMap.put("email", email.text.toString())
            hashMap.put("password", password.text.toString())
            val ret = myRetrofit().getRetrofit()
            val inter = ret.create(myIterface::class.java)
            val call = inter.postLogin(hashMap)
                .enqueue(object : retrofit2.Callback<login> {
                    override fun onResponse(call: Call<login>, response: Response<login>) {
                        if (response.isSuccessful) {
                            val intent = Intent(this@LoginActivity, MenuActivity::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(
                                this@LoginActivity,
                                response.code().toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<login>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, t.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }

                })
        }
        else{
            AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Input email and password.")
                .setPositiveButton("OK",null)
                .create()
                .show()
        }
    }
}