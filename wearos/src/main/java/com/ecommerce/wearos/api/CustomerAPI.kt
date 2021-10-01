package com.ecommerce.wearos.api



import com.ecommerce.wearos.entity.Customer
import com.ecommerce.wearos.response.LoginResponse
import com.ecommerce.wearos.response.UserProfileResponse


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
