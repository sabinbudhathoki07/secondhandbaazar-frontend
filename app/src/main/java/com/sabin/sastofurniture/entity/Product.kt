package com.sabin.sastofurniture.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
 class Product(
        @PrimaryKey(autoGenerate = false)
    val _id: String="",
    val ProductName: String? = null,
    val Product_Price: Int? = null,
    val CompanyRating: String? = null,
    val pimage: String? = null,
    val des: String?=null
):Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString()!!,
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(_id)
        parcel.writeString(ProductName)
        parcel.writeValue(Product_Price)
        parcel.writeString(CompanyRating)
        parcel.writeString(pimage)
        parcel.writeString(des)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}