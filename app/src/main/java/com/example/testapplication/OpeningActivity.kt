package com.example.testapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class OpeningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        var mapsButton= findViewById<Button>(R.id.mapsButton)
        var calendarButton = findViewById<Button>(R.id.calendarButton)
        var calculatorButton = findViewById<Button>(R.id.calculatorButton)
        var emailButton = findViewById<Button>(R.id.emailButton)

        mapsButton.setOnClickListener {

            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.google.com/maps")
            )
            startActivity(intent)
        }

        calendarButton.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW)
            val uri = Uri.parse(
                "content://com.android.calendar/time"
            )
            intent.data = uri
            startActivity(intent)

        }

        calculatorButton.setOnClickListener {

            val items = ArrayList<HashMap<String, Any>>()

            val pm = packageManager
            val packs = pm.getInstalledPackages(0)
            for (pi in packs) {
                if (pi.packageName.toString().lowercase(Locale.getDefault()).contains("calcul")) {
                    val map = HashMap<String, Any>()
                    map["appName"] = pi.applicationInfo.loadLabel(pm)
                    map["packageName"] = pi.packageName
                    items.add(map)
                }
            }

            if (items.size >= 1) {


                    val packageName = items[0]["packageName"] as String?
                    val i = pm.getLaunchIntentForPackage(packageName!!)
                    i?.let { startActivity(it) }

                val intent = Intent()
                intent.action = Intent.ACTION_MAIN
                intent.addCategory(Intent.CATEGORY_APP_CALCULATOR)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)

            } else {
                // Application not found
                Toast.makeText(this,"Application Not Found",Toast.LENGTH_LONG).show()
            }

        }

        emailButton.setOnClickListener {
            var email :String =  "mittalkshitij20@gmail.com"/* Your email address here */
            var subject : String = "Test Mail"/* Your subject here */
            var body : String = "This email is a test email"/* Your body here */
            var chooserTitle : String = "Title of Test Email"/* Your chooser title here */

            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, body)
            emailIntent.putExtra(Intent.EXTRA_TITLE,chooserTitle)
            startActivity(Intent.createChooser(emailIntent, "Chooser Title"))
        }
    }
}