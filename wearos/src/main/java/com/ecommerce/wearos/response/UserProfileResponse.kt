package com.ecommerce.wearos.response

import com.ecommerce.wearos.entity.Customer


data class UserProfileResponse(
        val success: Boolean? = null,
        val data : Customer?=null

)