package com.sabin.sastofurniture

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.repository.CustomerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class SignupActivity : AppCompatActivity() {

    private lateinit var fullName : EditText
    private lateinit var email : EditText
    private lateinit var etpassword : EditText
    private lateinit var cpassword : EditText

    private lateinit var signup : Button
    private lateinit var  mobileno :EditText
    private lateinit var  back :TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        fullName = findViewById(R.id.fullname)
        email = findViewById(R.id.email)
        etpassword = findViewById(R.id.etpassword)
        cpassword = findViewById(R.id.cPassword)
        signup = findViewById(R.id.signup)
        mobileno = findViewById(R.id.mobileno)
        back =findViewById(R.id.back)

        back.setOnClickListener setOnClickLsitener@{
            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
        }

        signup.setOnClickListener setOnClickLsitener@{

            val fullname = fullName.text.toString()
            val email = email.text.toString()
            val password = etpassword.text.toString()
            val CPassword = cpassword.text.toString()
            val mobileno = mobileno.text.toString()

            if (password != CPassword) {
                etpassword.error = "Password dont matched"
                etpassword.requestFocus()
                return@setOnClickLsitener
            } else {
                val customer = Customer(fullname = fullname, email = email, password = password, mobileno = mobileno)
                CoroutineScope(Dispatchers.IO).launch {

                    val repository = CustomerRepository()
                    val response = repository.registerCustomer(customer)
                    if(response.success == true){
                        ServiceBuilder.token = response.token
                        withContext(Main){
                            Toast.makeText(this@SignupActivity, "Success", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this@SignupActivity, LoginActivity::class.java))
                        }
                    }else{
                        withContext(Main){
                            Toast.makeText(this@SignupActivity, "Error registering user", Toast.LENGTH_SHORT).show()
                        }
                    }

                    CustomerDB.getInstance(this@SignupActivity).getCustomerDAO().registerCustomer(customer)

                    //Switching Thread
                    withContext(Main) {
                        Toast.makeText(
                                this@SignupActivity,
                                "User Registered",
                                Toast.LENGTH_SHORT
                        ).show()
                    }
                }


            }

        }

    }

}