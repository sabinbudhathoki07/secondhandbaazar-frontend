package com.sabin.sastofurniture.Fragments

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.sabin.sastofurniture.R
import com.sabin.sastofurniture.UpdateUser
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.db.CustomerDB
import com.sabin.sastofurniture.repository.CustomerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MyProfile : Fragment() {
    private lateinit var txtUserName : TextView
    private lateinit var txtPhoneNumber : TextView
    private lateinit var txtEmail : TextView
    private lateinit var edituser : Button

//   private lateinit var swipeRefreshLayout: SwipeRefreshLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)





            txtUserName = view.findViewById(R.id.txtUserName)
            txtPhoneNumber = view.findViewById(R.id.txtPhoneNumber)
            txtEmail = view.findViewById(R.id.txtEmail)
            edituser = view.findViewById(R.id.edituser)


            lifecycleScope.launch(Dispatchers.IO) {
                val repository = CustomerRepository()
                val response = repository.getUserData()
                if (response.success == true) {
                    val userData = response.data
                    CustomerDB.getInstance(requireContext()).getCustomerDAO().deleteCustomer(userData!!)
                    CustomerDB.getInstance(requireContext()).getCustomerDAO().registerCustomer(userData!!)
                    val userDetail = CustomerDB.getInstance(requireContext()).getCustomerDAO().getUser()
                    ServiceBuilder.userid = userDetail._id
                    withContext(Dispatchers.Main) {





                        txtUserName.text = "${userDetail.fullname}"
                        txtEmail.text = "${userDetail.email}"
                        txtPhoneNumber.text = "${userDetail.mobileno}"




                    }
                }
                edituser.setOnClickListener {
                    startActivity(Intent(activity, UpdateUser::class.java))
                }
            }

            return view
        }

    }


