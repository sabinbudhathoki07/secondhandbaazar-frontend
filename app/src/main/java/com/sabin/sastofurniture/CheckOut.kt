package com.sabin.sastofurniture


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast


import androidx.appcompat.app.AppCompatActivity

import com.sabin.sastofurniture.api.ServiceBuilder.userid
import com.sabin.sastofurniture.repository.FavouriteItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class CheckOut : AppCompatActivity() {



    private lateinit var btnOk: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.order_placed)
        btnOk = findViewById(R.id.btnOk)


        btnOk.setOnClickListener() {

            CoroutineScope(Dispatchers.IO).launch {
                val productRepository = FavouriteItemRepository()
                val response = productRepository.deleteAllFavouriteItem(userid!!)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(
                                this@CheckOut,
                                "Successfully placed order",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                }


                startActivity(Intent(this@CheckOut, DashboardActivity::class.java))

            }
        }

    }
}