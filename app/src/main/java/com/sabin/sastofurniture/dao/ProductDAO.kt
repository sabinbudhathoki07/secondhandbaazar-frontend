package com.sabin.sastofurniture.dao

import androidx.room.*
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.entity.Product


@Dao
    interface ProductDAO {

    @Query("Delete from `product`")
    suspend fun deleteProduct()

    @Insert
    suspend fun insertProducts(product: MutableList<Product>?)



    @Insert
    suspend fun registerProduct(product: Product)


    @Delete
    suspend fun deleteProduct(product: Product)

    @Query("Select * from Product")
    suspend fun  getProduct(): Product





}
