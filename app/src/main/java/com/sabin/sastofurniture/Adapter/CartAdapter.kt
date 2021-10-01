package com.sabin.sastofurniture.Adapter


import android.app.AlertDialog
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.sabin.sastofurniture.CartProductShow
import com.sabin.sastofurniture.DashboardActivity
import com.sabin.sastofurniture.Fragments.FavouriteFurniture
import com.sabin.sastofurniture.Fragments.MapsActivity
import com.sabin.sastofurniture.Fragments.ProductFragment
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.Show_Product
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.Cart
import com.sabin.sastofurniture.entity.CartModel
import com.sabin.sastofurniture.notification.NotificationChannels
import com.sabin.sastofurniture.repository.FavouriteItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception


class CartAdapter(val context: Context, val lstProducts: MutableList<CartModel>)
    : RecyclerView.Adapter<CartAdapter.ProductViewHolder>() {

    class ProductViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val product: TextView = view.findViewById(R.id.txtProductName)
        val price: TextView = view.findViewById(R.id.txtPrice)
        val rating: TextView = view.findViewById(R.id.txtRating)
        val pic: ImageView = view.findViewById(R.id.imgProduct)
        val delete: ImageView = view.findViewById(R.id.imgFav3)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fav_recycler, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = lstProducts[position]

        holder.product.text = product.ProductName
        holder.price.text = product.Product_Price.toString()
        holder.rating.text = product.CompanyRating
        holder.delete.setOnClickListener() {


            holder.delete.setImageResource(R.drawable.ic_removed)

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Delete favourite Product")
            builder.setMessage("Are you sure you want to delete ${product.ProductName} ??")
            builder.setIcon(android.R.drawable.ic_delete)
            builder.setPositiveButton("Yes") { _, _ ->

                CoroutineScope(Dispatchers.IO).launch {
                    try {
                        val productRepository = FavouriteItemRepository()
                        val response = productRepository.deleteFavouriteItem(product._id!!)
                        if (response.success == true) {
                            withContext(Dispatchers.Main) {
                                Toast.makeText(
                                    context,
                                    "Product Deleted",
                                    Toast.LENGTH_SHORT
                                ).show()
                                context.startActivity(Intent(context, DashboardActivity::class.java))

                            }
                            withContext(Dispatchers.Main) {
                                lstProducts.remove(product)
                                notifyDataSetChanged()

                            }
                        }
                    } catch (ex: Exception) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(
                                context,
                                ex.toString(),
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }

            }
            builder.setNegativeButton("No") { _, _ ->
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.setCancelable(false)
            alertDialog.show()



        }


        holder.pic.setOnClickListener{
            val intent = Intent(context,CartProductShow::class.java)
            intent.putExtra("cartproduct",product)
            context.startActivity(intent)
        }



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
        showNotification(lstProducts.size)
        return lstProducts.size
    }


    private fun showNotification(size: Int) {
        val notificationManager = NotificationManagerCompat.from(context!!)
        val activityIntent = Intent(context!!, MapsActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, activityIntent, 0)

        val notificationChannels = NotificationChannels(context!!)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(context!!, notificationChannels.CHANNEL_1)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("My notification")
                .setContentText("The total number of product are $size")
                .setColor(Color.BLUE)
                .setContentIntent(pendingIntent)
                .build()

        notificationManager.notify(1, notification)
    }
}



