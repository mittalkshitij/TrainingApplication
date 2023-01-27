package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var usernameEditTextSignup= findViewById<EditText>(R.id.usernameEditTextSignup)
        var passwordEditTextSignup= findViewById<EditText>(R.id.passwordEditTextSignup)
        var assetRadioGroup = findViewById<RadioGroup>(R.id.assetRadioGroup)
        var genderRadioGroup = findViewById<RadioGroup>(R.id.genderRadioGroup)
        var signUpButton=findViewById<Button>(R.id.signupButton)

        lateinit var assetRadioButton : RadioButton
        lateinit var genderRadioButton: RadioButton
        lateinit var assetChecked : String
        lateinit var genderChecked : String

        assetRadioGroup.setOnCheckedChangeListener { assetGroup , id ->

            assetRadioButton =findViewById<RadioButton>(id)
            assetChecked = assetRadioButton.text.toString()
        }

        genderRadioGroup.setOnCheckedChangeListener { assetGroup , id ->

            genderRadioButton =findViewById<RadioButton>(id)
            genderChecked = genderRadioButton.text.toString()
        }

        signUpButton.setOnClickListener {
            var user =
                User(usernameEditTextSignup.text.toString(), passwordEditTextSignup.text.toString(),assetChecked,genderChecked)
            var myIntent = Intent(this, UserDetailsActivity::class.java)
            myIntent.putExtra("un", usernameEditTextSignup.text.toString())
            myIntent.putExtra("pwd", passwordEditTextSignup.text.toString())
            myIntent.putExtra("asset", assetChecked)
            myIntent.putExtra("gender", genderChecked)
            myIntent.putExtra("obj", user)
            startActivity(myIntent)
        }


    }
}