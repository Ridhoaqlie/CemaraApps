package com.example.cemaraapps.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class DetailFamily(
    @field:SerializedName("error")
    val error: Boolean? = null,

    @field:SerializedName("message")
    val message: String? = null
)