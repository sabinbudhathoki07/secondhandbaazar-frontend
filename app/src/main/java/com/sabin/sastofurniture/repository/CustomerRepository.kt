package com.sabin.sastofurniture.repository

import com.sabin.sastofurniture.api.MyApiRequest
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.api.CustomerAPI
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.response.LoginResponse
import com.sabin.sastofurniture.response.UserProfileResponse


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

    suspend fun getUserData():UserProfileResponse{
        return apiRequest {
            myApi.getUser(ServiceBuilder.token!!)
        }
    }

    suspend fun updateUserData(id:String,customer: Customer):UserProfileResponse {
        return apiRequest {
            myApi.updateUser(ServiceBuilder.token!!, id, customer)
        }
    }


    }
