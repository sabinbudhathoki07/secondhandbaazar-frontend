package com.ecommerce.wearos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ecommerce.wearos.db.CustomerDB
import com.ecommerce.wearos.entity.Product
import com.ecommerce.wearos.repository.ProductRepository
import com.sabin.sastofurniture.Adapter.ProductAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductActivity : AppCompatActivity() {
    lateinit var furnitureRecycler : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        furnitureRecycler = findViewById(R.id.furnitureRecycler)
        CoroutineScope(Dispatchers.IO).launch {
            val repository = ProductRepository()
            val response = repository.getProduct()
            if(response.success==true){
                val lst = response.data

                withContext(Dispatchers.Main){
                    val adapter = ProductAdapter(applicationContext,lst as MutableList<Product>)
                    furnitureRecycler.adapter = adapter
                    furnitureRecycler.layoutManager = LinearLayoutManager(applicationContext)
                }
            }


}
    }
}