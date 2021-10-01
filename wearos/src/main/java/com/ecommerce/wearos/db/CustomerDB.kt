package com.ecommerce.wearos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(
entities = [],
version = 3
)
abstract class CustomerDB : RoomDatabase() {

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