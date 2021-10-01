package com.sabin.sastofurniture.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabin.sastofurniture.Adapter.ProductAdapter
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.entity.Product
import com.sabin.sastofurniture.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProductFragment : Fragment() {
    lateinit var furnitureRecycler : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_all_furniture, container, false)
        furnitureRecycler = view.findViewById(R.id.furnitureRecycler)
        CoroutineScope(Dispatchers.IO).launch {
            val repository = ProductRepository()
            val response = repository.getProduct()
            if(response.success==true){
                val lst = response.data
                CustomerDB.getInstance(requireContext()).getProductDAO().deleteProduct()
                CustomerDB.getInstance(requireContext()).getProductDAO().insertProducts(lst)
                withContext(Dispatchers.Main){
                    val adapter = ProductAdapter(context!!,lst as MutableList<Product>)
                    furnitureRecycler.adapter = adapter
                    furnitureRecycler.layoutManager = LinearLayoutManager(context!!)
                }
            }

        }
        return  view
    }

}