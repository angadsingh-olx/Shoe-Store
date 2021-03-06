package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginData (
    val email:String,
    val password: String
): Parcelable