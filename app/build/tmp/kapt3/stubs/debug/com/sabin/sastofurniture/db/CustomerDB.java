package com.sabin.sastofurniture.db;

import java.lang.System;

@androidx.room.Database(entities = {com.sabin.sastofurniture.entity.Product.class, com.sabin.sastofurniture.entity.Customer.class, com.sabin.sastofurniture.entity.CartModel.class}, version = 4)
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/sabin/sastofurniture/db/CustomerDB;", "Landroidx/room/RoomDatabase;", "()V", "getCartProductDAO", "Lcom/sabin/sastofurniture/dao/CartDAO;", "getCustomerDAO", "Lcom/sabin/sastofurniture/dao/CustomerDAO;", "getProductDAO", "Lcom/sabin/sastofurniture/dao/ProductDAO;", "Companion", "app_debug"})
public abstract class CustomerDB extends androidx.room.RoomDatabase {
    private static volatile com.sabin.sastofurniture.db.CustomerDB instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.sabin.sastofurniture.db.CustomerDB.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.sabin.sastofurniture.dao.CustomerDAO getCustomerDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.sabin.sastofurniture.dao.ProductDAO getProductDAO();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.sabin.sastofurniture.dao.CartDAO getCartProductDAO();
    
    public CustomerDB() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/sabin/sastofurniture/db/CustomerDB$Companion;", "", "()V", "instance", "Lcom/sabin/sastofurniture/db/CustomerDB;", "buildDatabase", "context", "Landroid/content/Context;", "getInstance", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.sabin.sastofurniture.db.CustomerDB getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private final com.sabin.sastofurniture.db.CustomerDB buildDatabase(android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}