package com.sabin.sastofurniture.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.sabin.sastofurniture.entity.CartModel
import com.sabin.sastofurniture.entity.Product
@Dao
interface CartDAO {

    @Query("Delete from CartModel")
    suspend fun deleteProduct()

    @Insert
    suspend fun insertProducts(list: List<CartModel>?)

    @Query("Select * from CartModel")
    suspend fun GetAllFav():List<CartModel>
}