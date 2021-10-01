package com.sabin.sastofurniture.response

import com.sabin.sastofurniture.entity.Product

data class ProductResponse (
    val success: Boolean? = null,
    val data: MutableList<Product>? =null
)

