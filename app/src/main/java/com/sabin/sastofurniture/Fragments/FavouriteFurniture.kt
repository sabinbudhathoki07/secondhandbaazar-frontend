package com.sabin.sastofurniture.Fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sabin.sastofurniture.Adapter.CartAdapter
import com.sabin.sastofurniture.CheckOut

import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.entity.Cart
import com.sabin.sastofurniture.entity.CartModel
import com.sabin.sastofurniture.entity.Product
import com.sabin.sastofurniture.repository.FavouriteItemRepository
import com.sabin.sastofurniture.repository.ProductRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class FavouriteFurniture : Fragment() {
    lateinit var furnitureRecyclerfav: RecyclerView
    private lateinit var btnConfirmOrder:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_favourite_furniture, container, false)

        btnConfirmOrder = view.findViewById(R.id.btnConfirmOrder)
        furnitureRecyclerfav = view.findViewById(R.id.furnitureRecyclerfav)


        loadvlaue()

        return view

    }



private fun loadvlaue() {
    var listNotes: List<CartModel>?
    CoroutineScope(Dispatchers.IO).launch {


        val repository = FavouriteItemRepository()
        val response = repository.getFavouriteItem(ServiceBuilder.userid!!)
        if (response.success == true) {
            val data = response.data
            var allnoteid: String? = null



            CustomerDB.getInstance(requireContext()).getCartProductDAO().deleteProduct()
            for (i in data!!.indices) {
                allnoteid = data[i].CartItemid


                val productrepo = ProductRepository()
                val proRes = productrepo.singleIteam(allnoteid!!)
                if (proRes.success == true) {
                    val datas = proRes.data
                    CustomerDB.getInstance(requireContext()).getCartProductDAO().insertProducts(proRes.data)
                }
            }


            val productlst = CustomerDB.getInstance(requireContext()).getCartProductDAO().GetAllFav()
            val list = productlst
            withContext(Main) {
                val adpater = CartAdapter(requireContext(), list as ArrayList<CartModel>)

                var sum = 0
                for (i in 0 until productlst.size) {
                    sum += productlst[i].Product_Price as Int
                }
                val total = "Place Order(Total: Rs. $sum)"
                btnConfirmOrder.text = total


                btnConfirmOrder.setOnClickListener(){
                    startActivity(Intent(context, CheckOut::class.java))

            }

                furnitureRecyclerfav.setHasFixedSize(true);
                furnitureRecyclerfav.layoutManager = LinearLayoutManager(activity)
                furnitureRecyclerfav.adapter = adpater;
            }
        }
    }
}
}







