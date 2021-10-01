package com.sabin.sastofurniture.api

import com.sabin.sastofurniture.entity.Cart
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.entity.Product
import com.sabin.sastofurniture.response.DeleteCartResponse
import com.sabin.sastofurniture.response.FavouriteItemResponse
import com.sabin.sastofurniture.response.GetCartResponse
import retrofit2.Response
import retrofit2.http.*

interface CartApi {

    //Register User

    @POST("cart/item")
    suspend fun insertFavoutiteItem(
            @Header("Authorization") token: String,
            @Body cart:Cart


    ) : Response<FavouriteItemResponse>


    @GET("cartitem/showall/{id}")
    suspend fun getFavouriteItem(
            @Header("Authorization") token: String,
            @Path("id") id:String



    ): Response<FavouriteItemResponse>

    @DELETE("favouriteitem/delete/{id}")
    suspend fun deleteFavouriteItem(
            @Header("Authorization") token:String,
            @Path("id") id:String
    ):Response<DeleteCartResponse>

    @DELETE("allfavouriteitem/delete/{id}")
    suspend fun deleteAllFavouriteItem(
            @Header("Authorization") token:String,
            @Path("id") id:String
    ):Response<DeleteCartResponse>


}