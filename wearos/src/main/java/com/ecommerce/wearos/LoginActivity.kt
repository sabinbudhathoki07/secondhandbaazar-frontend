package com.ecommerce.wearos


import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils

import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


import com.ecommerce.wearos.api.ServiceBuilder
import com.ecommerce.wearos.entity.Customer
import com.ecommerce.wearos.notification.NotificationChannels
import com.ecommerce.wearos.repository.CustomerRepository



import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity()  {

    private lateinit var email : EditText
    private lateinit var password : EditText

    private  lateinit var signup : TextView
    private  lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        btnlogin = findViewById(R.id.btnlogin)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)



        btnlogin.setOnClickListener {
            login()
        }


    }






    private fun login() {
        if (validation()) {

            val email = email.text.toString()
            val password = password.text.toString()

            CoroutineScope(Dispatchers.IO).launch {
                val customer = Customer(email = email, password = password)
                try {
                    val repository = CustomerRepository()
                    val response = repository.loginUser(customer)
                    if (response.success == true) {
                        showNotification()
                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userid=response.id
                        withContext(Dispatchers.Main)
                        {
                         startActivity(Intent(this@LoginActivity, ProductActivity::class.java))
                            Toast.makeText(this@LoginActivity, "logging successfull as ${email}", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(this@LoginActivity, "Invalid credentials", Toast.LENGTH_SHORT).show()
                        }
                    }
                } catch (ex: Exception) {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(this@LoginActivity, "$ex", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
    private fun showNotification() {
        val notificationManager = NotificationManagerCompat.from(applicationContext!!)
        val activityIntent = Intent(applicationContext, ProductActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(applicationContext, 0, activityIntent, 0)

        val notificationChannels = NotificationChannels(applicationContext!!)
        notificationChannels.createNotificationChannels()

        val notification = NotificationCompat.Builder(applicationContext!!, notificationChannels.CHANNEL_1)
                .setSmallIcon(R.drawable.notification)
                .setContentTitle("My notification")
                .setContentText("Welcome to Dashboard")
                .setColor(Color.BLUE)
                .setContentIntent(pendingIntent)
                .build()


        notificationManager.notify(1, notification)

    }



    private fun validation():Boolean{
        var flag =true
        if (TextUtils.isEmpty(email.text)){
            email.error = "Enter Email Id"
            email.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(password.text)){
            password.error = "Enter Password"
            password.requestFocus()
            flag = false
        }
        return flag
    }
}