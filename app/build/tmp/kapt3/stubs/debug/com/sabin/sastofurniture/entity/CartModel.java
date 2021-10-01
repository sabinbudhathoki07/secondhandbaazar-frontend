package com.sabin.sastofurniture.entity;

import java.lang.System;

@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BW\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0006H\u0016R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010\u00a8\u0006\u001f"}, d2 = {"Lcom/sabin/sastofurniture/entity/CartModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "pid", "", "_id", "", "ProductName", "Product_Price", "CompanyRating", "pimage", "des", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCompanyRating", "()Ljava/lang/String;", "getProductName", "getProduct_Price", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "get_id", "getDes", "getPid", "()I", "getPimage", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_debug"})
public final class CartModel implements android.os.Parcelable {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final int pid = 0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String _id = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String ProductName = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer Product_Price = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String CompanyRating = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String pimage = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String des = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.sabin.sastofurniture.entity.CartModel.CREATOR CREATOR = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public final int getPid() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String get_id() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getProductName() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProduct_Price() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getCompanyRating() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getPimage() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDes() {
        return null;
    }
    
    public CartModel(int pid, @org.jetbrains.annotations.Nullable()
    java.lang.String _id, @org.jetbrains.annotations.Nullable()
    java.lang.String ProductName, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Product_Price, @org.jetbrains.annotations.Nullable()
    java.lang.String CompanyRating, @org.jetbrains.annotations.Nullable()
    java.lang.String pimage, @org.jetbrains.annotations.Nullable()
    java.lang.String des) {
        super();
    }
    
    public CartModel() {
        super();
    }
    
    public CartModel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/sabin/sastofurniture/entity/CartModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/sabin/sastofurniture/entity/CartModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/sabin/sastofurniture/entity/CartModel;", "app_debug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.sabin.sastofurniture.entity.CartModel> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.sabin.sastofurniture.entity.CartModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.sabin.sastofurniture.entity.CartModel[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}