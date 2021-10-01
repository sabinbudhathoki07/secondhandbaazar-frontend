package com.sabin.sastofurniture.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import com.sabin.sastofurniture.entity.Customer

@Dao
interface CustomerDAO {
    //insert function
    @Insert
    suspend fun registerCustomer(customer: Customer)


    @Query("select * from Customer where email=(:email) and password=(:password)")
    suspend fun checkuser(email: String, password: String): Customer
    @Delete
    suspend fun deleteCustomer(customer: Customer)


    @Query("Delete from `Customer`")
    suspend fun deleteCustomers()

    @Query("Select * from Customer")
    suspend fun  getUser(): Customer
}