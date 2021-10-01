package com.sabin.sastofurniture.repository

import android.content.Context
import com.sabin.sastofurniture.api.MyApiRequest
import com.sabin.sastofurniture.api.ProductApi
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.entity.Product
import com.sabin.sastofurniture.response.*
import okhttp3.MultipartBody


class ProductRepository : MyApiRequest() {
    private val productApi = ServiceBuilder.buildService(ProductApi::class.java)

    suspend fun getProduct(): ProductResponse {
        return apiRequest {
            productApi.getAllProducts(ServiceBuilder.token!!)
        }
    }

    suspend fun getProductById(): ProductResponse {
        return apiRequest {
            productApi.getProductById(ServiceBuilder.token!!)
        }
    }


    suspend fun getProductData(): ShowProductResponse {
        return apiRequest {
            productApi.getProduct(ServiceBuilder.token!!)
        }
    }
    suspend fun singleIteam(id:String): CartResponse {
        return apiRequest {
            productApi.getProductsingleItem(ServiceBuilder.token!!,id)
        }
    }

}
