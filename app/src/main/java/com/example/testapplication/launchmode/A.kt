package com.example.testapplication.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.testapplication.R

class A : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_a)

        var aTextView= findViewById<TextView>(R.id.aTextView)

        aTextView.setOnClickListener {

            var intent= Intent(this, B::class.java)
            startActivity(intent)
        }
        Log.i("tag","A Activity Created")

    }

    override fun onStart() {
        super.onStart()
        Log.i("tag","A Activity Started")
    }

    override fun onResume(){
        super.onResume()
        Log.i("tag","A Activity Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("tag","A Activity Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("tag","A Activity Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("tag","A Activity Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("tag","A Activity Destroy")
    }

}