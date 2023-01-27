package com.example.testapplication

import android.os.Parcelable
import android.widget.RadioGroup
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var uname : String, var pwd : String,var asset : String, var gender : String) : Parcelable {
}