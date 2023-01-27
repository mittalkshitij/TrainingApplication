package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userNameEditText =findViewById<EditText>(R.id.usernameEditText)
        var passwordEditText =findViewById<EditText>(R.id.passwordEditText)
        var loginButton = findViewById<AppCompatButton>(R.id.loginButton)






            loginButton.setOnClickListener {

                var username= userNameEditText.text.toString()
                var password=passwordEditText.text.toString()

                if (username == "abc" && password == "xyz") {

                    var intent = Intent(this, SecondActivity::class.java)

                    val bundle = Bundle()

                    bundle.putString("username", username)
                    bundle.putString("password", password)

                    intent.putExtras(bundle)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show()
                }
            }
    }
}


