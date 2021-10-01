package com.ecommerce.wearos.response

import com.ecommerce.wearos.entity.Product


data class ProductResponse (
    val success: Boolean? = null,
    val data: MutableList<Product>? =null
)

