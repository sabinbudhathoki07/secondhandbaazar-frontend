package com.sabin.sastofurniture

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.text.TextUtils

import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat


import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.repository.CustomerRepository
import com.sabin.sastofurniture.utils.getSharedPref
import com.sabin.sastofurniture.utils.saveSharedPref


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class LoginActivity : AppCompatActivity()  {
    private val permissions = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION
    )
    private lateinit var emails : EditText
    private lateinit var passwords : EditText

    private  lateinit var signup : TextView
    private  lateinit var btnlogin : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        signup= findViewById(R.id.signup)
        btnlogin = findViewById(R.id.login)
        emails = findViewById(R.id.email)
        passwords = findViewById(R.id.password)

        checkRunTimePermission()

        btnlogin.setOnClickListener {
            login()
        }

        signup.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignupActivity::class.java))
        }

    }

    private fun checkRunTimePermission() {
        if (!hasPermission()) {
            requestPermission()

        }
    }

    private fun hasPermission(): Boolean {
        var hasPermission = true
        for (permission in permissions) {
            if (ActivityCompat.checkSelfPermission(
                            this,
                            permission
                    ) != PackageManager.PERMISSION_GRANTED
            ) {
                hasPermission = false
                break
            }
        }
        return hasPermission
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this@LoginActivity, permissions, 1)

    }

    fun login() {
        val user = Customer(email = emails.text.toString(), password = passwords.text.toString())

        CoroutineScope(Dispatchers.IO).launch {
            try {
                if (validation()) {
                    val repository = CustomerRepository()
                    val response = repository.loginUser(user)
                    val data = response.data
                    val listdata = data?.get(0)
                    val email = listdata?.email
                    if (response.success == true) {
                        val us = Customer(
                            _id = response.id!!,
                            email = emails.text.toString(),
                            password = passwords.text.toString()
                        )
                        CustomerDB.getInstance(this@LoginActivity).getCustomerDAO()
                            .deleteCustomers()
                        val sharedPref =
                            getSharedPreferences("MyPref", AppCompatActivity.MODE_PRIVATE)
                        val editor = sharedPref.edit()
                        editor.remove("_id")
                        editor.remove("email")
                        editor.remove("password")
                            .apply()
                        CustomerDB.getInstance(this@LoginActivity).getCustomerDAO()
                            .registerCustomer(us)
                        saveSharedPref(
                            _id = response.id!!,
                            email = emails.text.toString(),
                            password = passwords.text.toString()
                        )
                        ServiceBuilder.token = "Bearer ${response.token}"
                        ServiceBuilder.userid = response.id
                        withContext(Main) {
                            Toast.makeText(this@LoginActivity, "${response.id}", Toast.LENGTH_SHORT)
                                .show()
                            startActivity(Intent(this@LoginActivity, DashboardActivity::class.java))
                        }
                    } else {
                        withContext(Main) {
                            Toast.makeText(this@LoginActivity, "error", Toast.LENGTH_SHORT)
                                .show()

                        }
                    }

                }
            }catch (ex:Exception){
                withContext(Main){
                    Toast.makeText(this@LoginActivity, "Invalid Credential", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }





    private fun validation():Boolean{
        var flag =true
        if (TextUtils.isEmpty(emails.text)){
            emails.error = "Enter Username"
            emails.requestFocus()
            flag = false
        }
        else if (TextUtils.isEmpty(passwords.text)){
            passwords.error = "Enter Password"
            passwords.requestFocus()
            flag = false
        }
        return flag
    }
}