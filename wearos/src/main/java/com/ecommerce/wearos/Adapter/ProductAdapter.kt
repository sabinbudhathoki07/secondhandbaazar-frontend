package com.sabin.sastofurniture.Adapter


import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ecommerce.wearos.ProductActivity
import com.ecommerce.wearos.R
import com.ecommerce.wearos.api.ServiceBuilder
import com.ecommerce.wearos.entity.Product
import com.ecommerce.wearos.notification.NotificationChannels


class ProductAdapter(val context: Context, val lstProducts: MutableList<Product>)
    : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val product: TextView = view.findViewById(R.id.txtProductName)
        val price: TextView = view.findViewById(R.id.txtPrice)
        val rating: TextView = view.findViewById(R.id.txtRating)
        val pic: ImageView = view.findViewById(R.id.imgProduct)



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.product_recyclerview, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

        val product = lstProducts[position]
        holder.product.text = product.ProductName
        holder.price.text = product.Product_Price.toString()
        holder.rating.text = product.CompanyRating




        Glide.with(context).load(product.pimage).into(holder.pic)
        val imagePath = ServiceBuilder.loadImagePath() + product.pimage
        if (!product.pimage.equals("no-photo.jpg")) {
            Glide.with(context)
                    .load(imagePath)
                    .fitCenter()
                    .into(holder.pic)
        }
    }

    override fun getItemCount(): Int {

        return lstProducts.size


    }


}







