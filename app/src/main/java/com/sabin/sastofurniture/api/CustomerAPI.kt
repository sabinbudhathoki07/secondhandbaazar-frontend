package com.sabin.sastofurniture.api



import androidx.room.Delete
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.response.LoginResponse
import com.sabin.sastofurniture.response.UserProfileResponse

import retrofit2.Response
import retrofit2.http.*


interface CustomerAPI {

        //Register User

        @POST("customers/signup")
        suspend fun registerCustomer(
            @Body user : Customer
        ) : Response<LoginResponse>

        //Login user
        @POST("customer/login")
        suspend fun checkUser(

                @Body customer: Customer
        ): Response<LoginResponse>


        @PUT("customer/update/{id}")
        suspend fun  updateUser(
                @Header("Authorization")token:String,
               @Path("id")id:String,
                @Body customer: Customer

        ):Response<UserProfileResponse>

        @GET("customer/account")
        suspend fun getUser(
                @Header("Authorization") token:String
        ):Response<UserProfileResponse>



}
