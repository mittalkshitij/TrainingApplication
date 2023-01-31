package com.example.testapplication.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.testapplication.R

class C : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c)

        var cTextview= findViewById<TextView>(R.id.cTextview)

        cTextview.setOnClickListener {

            var intent= Intent(this, A::class.java)
            startActivity(intent)
        }

        Log.i("tag","C Activity Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("tag","C Activity Started")
    }

    override fun onResume(){
        super.onResume()
        Log.i("tag","C Activity Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("tag","C Activity Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("tag","C Activity Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("tag","C Activity Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("tag","C Activity Destroy")
    }
}