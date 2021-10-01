package com.sabin.sastofurniture.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sabin.sastofurniture.dao.CartDAO
import com.sabin.sastofurniture.dao.CustomerDAO
import com.sabin.sastofurniture.dao.ProductDAO
import com.sabin.sastofurniture.entity.CartModel
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.entity.Product

@Database(
entities = [(Product::class),(Customer::class),(CartModel::class)],
version = 4
)
abstract class CustomerDB : RoomDatabase() {

    abstract fun getCustomerDAO() : CustomerDAO
    abstract  fun getProductDAO(): ProductDAO
    abstract  fun getCartProductDAO(): CartDAO



    companion object{
        @Volatile
        private var instance : CustomerDB? = null
        fun getInstance(context : Context):CustomerDB{
            if (instance == null){
                synchronized(CustomerDB::class){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context)=
            Room.databaseBuilder(
                context.applicationContext,
                CustomerDB::class.java,
                "CustomerDB"
            ).build()
    }

}