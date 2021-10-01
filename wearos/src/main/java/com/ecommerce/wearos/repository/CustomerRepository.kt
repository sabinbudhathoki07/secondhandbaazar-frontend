package com.ecommerce.wearos.repository

import com.ecommerce.wearos.api.CustomerAPI
import com.ecommerce.wearos.api.MyApiRequest
import com.ecommerce.wearos.api.ServiceBuilder
import com.ecommerce.wearos.entity.Customer
import com.ecommerce.wearos.response.LoginResponse
import com.ecommerce.wearos.response.UserProfileResponse


class CustomerRepository :
        MyApiRequest() {
    val myApi = ServiceBuilder.buildService(CustomerAPI::class.java)
    suspend fun registerCustomer(customer: Customer): LoginResponse {
        return apiRequest {
            myApi.registerCustomer(customer)
        }
    }
    suspend fun loginUser(customer: Customer):LoginResponse{
        return apiRequest {
            myApi.checkUser(customer)
        }
    }

    suspend fun getUserData(): UserProfileResponse {
        return apiRequest {
            myApi.getUser(ServiceBuilder.token!!)
        }
    }

    suspend fun updateUserData(id:String,customer:Customer):UserProfileResponse{
        return apiRequest {
            myApi.updateUser(ServiceBuilder.token!!,id,customer)
        }
    }
}