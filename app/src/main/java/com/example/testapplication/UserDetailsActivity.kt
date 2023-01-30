package com.example.testapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        var usernameTextViewDetails = findViewById<TextView>(R.id.usernameTextViewDetails)
        var passwordTextViewDetails = findViewById<TextView>(R.id.passwordTextviewDetails)
        var assetTextView=findViewById<TextView>(R.id.assetTextView)
        var genderTextView=findViewById<TextView>(R.id.genderTextView)


        var res : User? = intent.getParcelableExtra<User>("obj")
        usernameTextViewDetails.setText("Username : "+"${res?.uname.toString()} ")
        passwordTextViewDetails.setText("Password : "+"${res?.pwd.toString()}")
        assetTextView.setText("Asset : "+"${res?.asset.toString()}")
        genderTextView.setText("Gender : "+"${res?.gender.toString()}")


    }


}