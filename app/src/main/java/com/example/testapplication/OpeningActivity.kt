package com.example.testapplication


import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class OpeningActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opening)

        var mapsButton = findViewById<Button>(R.id.mapsButton)
        var calendarButton = findViewById<Button>(R.id.calendarButton)
        var calculatorButton = findViewById<Button>(R.id.calculatorButton)
        var emailButton = findViewById<Button>(R.id.emailButton)
        var alertButton= findViewById<Button>(R.id.alertButton)
        var customAlertButton = findViewById<Button>(R.id.customAlertButton)
        var notificationButton = findViewById<Button>(R.id.notificationButton)


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
                    Toast.makeText(this, "Application Not Found", Toast.LENGTH_LONG).show()
                }
            }



        emailButton.setOnClickListener {
            var email: String = "mittalkshitij20@gmail.com"/* Your email address here */
            var subject: String = "Test Mail"/* Your subject here */
            var body: String = "This email is a test email"/* Your body here */
            var chooserTitle: String = "Title of Test Email"/* Your chooser title here */

            val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email"))
            emailIntent.setDataAndType(Uri.parse("mailto:$email"), "message/rfc822")
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            emailIntent.putExtra(Intent.EXTRA_TEXT, body)
            emailIntent.putExtra(Intent.EXTRA_TITLE, chooserTitle)
            startActivity(Intent.createChooser(emailIntent, "Chooser Title"))
        }


        alertButton.setOnClickListener {
            var builder = AlertDialog.Builder(this)
                .setTitle("My Alert Dialog")
                .setMessage("do you want to exit the App ?")
                .setCancelable(false)
                .setIcon(R.drawable.ic_launcher_background)

                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        dialogInterface, i ->
                    this.finish()
                })
                .setNegativeButton("NO", DialogInterface.OnClickListener {
                        dialogInterface, i ->

                })
                .setNeutralButton("ne", DialogInterface.OnClickListener { dialog, which ->


                })

            var ad = builder.create()
            ad.show()
        }

        customAlertButton.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Name")

            val customLayout: View = layoutInflater
                .inflate(
                    R.layout.custom_alertdialog,
                    null
                )
            builder.setView(customLayout)

            builder
                .setPositiveButton("OK") { dialog, which ->

                    val editText = customLayout
                        .findViewById<EditText>(
                            R.id.customEdittext
                        )
                }

            val dialog = builder.create()
            dialog.show()

        }

        notificationButton.setOnClickListener {

            //val intent = Intent(this, SecondActivity::class.java)
            val channelId = "notifications"
            val description = "Test notification"
            lateinit var notificationManager: NotificationManager
            lateinit var notificationChannel: NotificationChannel
            lateinit var notificationBuilder: Notification.Builder

            notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            var myIntent = Intent(this, SecondActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, 0, myIntent, PendingIntent.FLAG_IMMUTABLE)

            if(Build.VERSION.SDK_INT >= 26){
                notificationChannel = NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)
                notificationBuilder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_launcher_foreground)
                    .setContentText("You have been logged out!")
                    .setContentTitle("Warning")
                    .setContentIntent(pendingIntent)
            }

            AlertDialog.Builder(this)
                .setTitle("Exit Application")
                .setMessage("Are you sure?")
                .setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener {
                        _, _ ->

                    notificationManager.notify(1234, notificationBuilder.build())
//                    this.startActivity(intent)
                })
                .setNegativeButton("NO", DialogInterface.OnClickListener {
                        _, _ ->

                }).create().show()
        }


    }
}