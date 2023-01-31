package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var handler= Handler()

        Thread{


            for(i in 1..3){

                Thread.sleep(1000)

                handler.post{

                }
            }

            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)

        }.start()


    }
}