package com.sabin.sastofurniture.api

import com.sabin.sastofurniture.response.*
import retrofit2.Response
import retrofit2.http.*
interface ProductApi {


    @GET("product/showalls")
    suspend fun getAllProducts(
        @Header("Authorization") token: String
    ): Response<ProductResponse>


    @GET("product/showall")
    suspend fun getProductById(
            @Header("Authorization") token: String
    ): Response<ProductResponse>

    @GET("product/item")
    suspend fun getProduct(
            @Header("Authorization") token:String
    ):Response<ShowProductResponse>

    @GET("product/single/{id}")
    suspend fun getProductsingleItem(
        @Header("Authorization") token:String,
        @Path("id") id:String
    ):Response<CartResponse>
}