package com.ecommerce.wearos.api


import com.ecommerce.wearos.response.ProductResponse
import com.ecommerce.wearos.response.ShowProductResponse
import retrofit2.Response
import retrofit2.http.*
interface ProductApi {


    @GET("product/showalls")
    suspend fun getAllProducts(
        @Header("Authorization") token: String
    ): Response<ProductResponse>


    @GET("product/showall:id")
    suspend fun getProductById(
            @Header("Authorization") token: String
    ): Response<ProductResponse>

    @GET("product/item")
    suspend fun getProduct(
            @Header("Authorization") token:String
    ):Response<ShowProductResponse>


}