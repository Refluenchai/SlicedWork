package com.slicedwork.slicedwork.domain.model

import android.net.Uri
import java.io.Serializable

data class User(
    var id: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var birthDate: String = "",
    var gender: Int = 0,
    var phoneNumber: String = "",
    var username: String = "",
    var email: String = "",
    var password: String = "",
    var picture: String = Uri.parse("R.drawable_ic_profile").toString()
): Serializable
