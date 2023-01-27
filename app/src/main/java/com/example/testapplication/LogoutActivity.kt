package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LogoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logout)

        var logoutButton =findViewById<Button>(R.id.logoutButton)


        logoutButton.setOnClickListener {
            var intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}