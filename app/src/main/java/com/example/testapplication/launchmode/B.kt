package com.example.testapplication.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.testapplication.R

class B : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)

        var bTextView= findViewById<TextView>(R.id.bTextView)

        bTextView.setOnClickListener {

            var intent= Intent(this, C::class.java)
            startActivity(intent)
        }
        Log.i("tag","B Activity Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("tag","B Activity Started")
    }

    override fun onResume(){
        super.onResume()
        Log.i("tag","B Activity Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("tag","B Activity Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("tag","B Activity Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("tag","B Activity Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("tag","B Activity Destroy")
    }


}