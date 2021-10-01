package com.ecommerce.wearos.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class  Customer(
        @PrimaryKey
        val _id: String ="",
        val fullname : String? = null,
        val email : String? = null,
        val password : String? = null,
        val mobileno : String? =null,
        val pimage : String? =null

): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString()!!,
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }
        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(_id)
                parcel.writeString(fullname)
                parcel.writeString(email)
                parcel.writeString(password)
                parcel.writeString(mobileno)

        }
        override fun describeContents(): Int {
                return 0
        }
        companion object CREATOR : Parcelable.Creator<Customer> {
                override fun createFromParcel(parcel: Parcel): Customer {
                        return Customer(parcel)
                }
                override fun newArray(size: Int): Array<Customer?> {
                        return arrayOfNulls(size)
                }
        }
}
