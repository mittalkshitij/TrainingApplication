package com.example.testapplication.launchmode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.LineBackgroundSpan.Standard
import android.util.Log
import android.widget.TextView
import com.example.testapplication.R

class StandardLaunchModeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standard_launch_mode)

        var textView =findViewById<TextView>(R.id.standardTextView)

        textView.setOnClickListener {

            var intent=Intent(this, A::class.java)
            startActivity(intent)
        }

        Log.i("tag","Standard Activity Created")
    }

    override fun onStart() {
        super.onStart()
        Log.i("tag","Standard Activity Started")
    }

    override fun onResume(){
        super.onResume()
        Log.i("tag","Standard Activity Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("tag","Standard Activity Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("tag","Standard Activity Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("tag","Standard Activity Restart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("tag","Standard Activity Destroy")
    }



}