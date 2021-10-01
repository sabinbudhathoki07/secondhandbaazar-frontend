package com.sabin.sastofurniture

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.sabin.sastofurniture.Fragments.MyProfile
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.repository.CustomerRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class UpdateUser:AppCompatActivity() {

    private lateinit var txtUserName: TextView
    private lateinit var txtPhoneNumber: TextView
    private lateinit var updateuser: Button
    private lateinit var imgUserImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_update_user)
        txtUserName = findViewById(R.id.txtUserName)
        txtPhoneNumber = findViewById(R.id.txtPhoneNumber)

        updateuser = findViewById(R.id.updateuser)
        imgUserImage = findViewById(R.id.imgUserImage)

        updateuser.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val userId = ServiceBuilder.userid
                val updateData =
                        Customer(
                                fullname = txtUserName.text.toString(),
                                mobileno = txtPhoneNumber.text.toString()

                        )
                val repository = CustomerRepository()
                val response = repository.updateUserData(id=userId!!,updateData)
                if (response.success == true) {
                    withContext(Dispatchers.Main) {



                    }
                }
            }
            Toast.makeText(this@UpdateUser, "User Updated", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@UpdateUser,DashboardActivity::class.java))
        }

}
}
