package com.ecommerce.wearos.response

import com.ecommerce.wearos.entity.Product


data class ShowProductResponse (
        val success: Boolean? = null,
        val data : Product?=null
        )
