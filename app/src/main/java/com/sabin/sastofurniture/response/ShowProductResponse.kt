package com.sabin.sastofurniture.response

import com.sabin.sastofurniture.entity.Product

data class ShowProductResponse (
        val success: Boolean? = null,
        val data : Product?=null
        )
