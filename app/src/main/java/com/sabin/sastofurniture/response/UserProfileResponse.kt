package com.sabin.sastofurniture.response

import com.sabin.sastofurniture.entity.Customer

data class UserProfileResponse(
        val success: Boolean? = null,
        val data : Customer?=null,
        val id : String?=""

)