package com.example.cemaraapps.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @field:SerializedName("Code")
    val code: String,
    @field:SerializedName("client_id")
    val client_id: String,
    @field:SerializedName("client_secret")
    val client_secret: String,
    @field:SerializedName("grant_type")
    val grant_type: String,
    @field:SerializedName("redirect_uri")
    val redirect_uri: String,
    @field:SerializedName("access_token")
    val access_token: String
)

data class FamilyResponse(
    @field:SerializedName("statusCode")
    val statusCode: String,
    @field:SerializedName("error")
    val error: String,
    @field:SerializedName("message")
    val message: String
)

