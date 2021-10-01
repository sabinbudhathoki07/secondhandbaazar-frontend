package com.sabin.sastofurniture.response

import com.sabin.sastofurniture.entity.Customer

data class LoginResponse(
    val success : Boolean? = null,
    val token : String? = null,
    val data : List<Customer>? = null,
    val id : String? = null,
)