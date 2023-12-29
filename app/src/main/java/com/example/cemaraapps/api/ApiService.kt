package com.example.cemaraapps.api

import com.example.cemaraapps.model.DetailFamily
import com.example.cemaraapps.model.LoginResponse
import com.example.cemaraapps.model.ResponseFamily
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @FormUrlEncoded
    @POST("family")
    fun family(
        @Field("name") name: String
    ): Call<ResponseFamily>

    @GET("family")
    fun FamName(
        @Header("Authorization") name: String
    ): Call<DetailFamily>


    @FormUrlEncoded
    @POST("token")
    fun getToken(
        @Field("code") code: String,
        @Field("client_id") client_id: String,
        @Field("client_secret") client_secret: String,
        @Field("grant_type") grant_type:String,
        @Field("redirect_uri")redirect_uri:String
    ): Call<LoginResponse>
}