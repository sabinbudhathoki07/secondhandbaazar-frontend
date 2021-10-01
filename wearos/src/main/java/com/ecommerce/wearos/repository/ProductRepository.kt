package com.ecommerce.wearos.repository


import com.ecommerce.wearos.api.MyApiRequest
import com.ecommerce.wearos.api.ProductApi
import com.ecommerce.wearos.api.ServiceBuilder
import com.ecommerce.wearos.response.ProductResponse
import com.ecommerce.wearos.response.ShowProductResponse



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

}
