package com.ecommerce.wearos.response

import com.ecommerce.wearos.entity.Customer


data class LoginResponse(
    val success : Boolean? = null,
    val token : String? = null,
    val data : List<Customer>? = null,
    val id : String? = null
)