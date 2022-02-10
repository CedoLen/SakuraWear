package com.example.sakurawear

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import com.example.sakurawear.databinding.ActivityMainBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val time = object : CountDownTimer(3000,1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }


        }
        time.start()

    }
}