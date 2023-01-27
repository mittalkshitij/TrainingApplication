package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var usernameTextView = findViewById<TextView>(R.id.usernameTextView)
        var passwordTextView = findViewById<TextView>(R.id.passwordTextview)
        var backButton =findViewById<Button>(R.id.backButton)
        var nextButton=findViewById<Button>(R.id.nextButton)

        var bundle = intent.extras

        var res1 = bundle?.getString("username")
        var res2 = bundle?.getString("password")

        /*Toast.makeText(this,res1.toString(),Toast.LENGTH_LONG).show()
        Toast.makeText(this,res2.toString(),Toast.LENGTH_LONG).show()*/

        usernameTextView.setText("Username : "+res1.toString())
        passwordTextView.setText("Password : "+res2.toString())

        backButton.setOnClickListener {
            onBackPressed()
        }

        nextButton.setOnClickListener {

            var intent= Intent(this,LogoutActivity::class.java)
            startActivity(intent)
        }


    }
}