package com.example.testapplication

import android.R.layout
import android.content.Intent
import android.os.Bundle
import android.view.Gravity
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
        var signButton=findViewById<AppCompatButton>(R.id.signButton)

            loginButton.setOnClickListener {

                var username: String?= userNameEditText?.text.toString()
                var password: String?=passwordEditText?.text.toString()

                if (username == "abc" && password == "xyz") {

                    var intent = Intent(this, SecondActivity::class.java)

                    val bundle = Bundle()

                    bundle.putString("username", username)
                    bundle.putString("password", password)

                    intent.putExtras(bundle)
                    startActivity(intent)

                } else {

                    val toast = Toast(this)
                    toast.setText("Login Failed")
                    toast.duration = Toast.LENGTH_LONG
                    toast.show()
                }
            }

        signButton.setOnClickListener {

            var intent=Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}


