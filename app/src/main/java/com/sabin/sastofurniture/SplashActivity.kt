package com.sabin.sastofurniture

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.repository.CustomerRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Main
import kotlin.coroutines.CoroutineContext

class SplashActivity:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val sharedPref = getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
        val emailPref = sharedPref.getString("email", null)
        val passwordPref = sharedPref.getString("password", "")
        CoroutineScope(Dispatchers.IO).launch {
            delay(1000)
            if (emailPref != null) {
                withContext(Main) {
                    Toast.makeText(this@SplashActivity, "$emailPref", Toast.LENGTH_SHORT).show()
                    val repository = CustomerRepository()
                    val customer = Customer(email = emailPref, password = passwordPref)
                    val response = repository.loginUser(customer)
                    if (response.success == true) {
                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userid = response.id
                        delay(500)
                        startActivity(Intent(this@SplashActivity, DashboardActivity::class.java)
                        )
                        finish()
                    }
                }
            } else {
                withContext(Main) {
                    startActivity(
                            Intent(
                                    this@SplashActivity,
                                    LoginActivity::class.java
                            )
                    )
                }
                finish()
            }
        }

    }
}