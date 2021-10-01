package com.sabin.sastofurniture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.CartModel
import com.sabin.sastofurniture.entity.Product



class CartProductShow : AppCompatActivity() {

    private lateinit var ProductNames :TextView
    private lateinit var Ratings:TextView
    private lateinit var Prices :TextView
    private lateinit var  desss :TextView
    private lateinit var images:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show__product)
        ProductNames=findViewById(R.id.ProductName)
        Prices=findViewById(R.id.Price)
        Ratings= findViewById(R.id.Rating)
        images=findViewById(R.id.image)
        desss =findViewById(R.id.des)

        val intent = intent.getParcelableExtra<CartModel>("cartproduct")
        if(intent!=null)
        {

            val productnamees= intent!!.ProductName
            val Ratinges = intent!!.CompanyRating
            val Pricees =intent!!.Product_Price.toString()
            val deses = intent!!.des


            ProductNames.text=productnamees
            Ratings.text=Ratinges
            Prices.text=Pricees
            desss.text=deses

            val imagePath = ServiceBuilder.loadImagePath() + intent!!.pimage
            if (!intent.pimage.equals("nophoto.png")) {
                Glide.with(this)
                        .load(imagePath)
                        .fitCenter()
                        .into(images)
            }
        }


    }
}


