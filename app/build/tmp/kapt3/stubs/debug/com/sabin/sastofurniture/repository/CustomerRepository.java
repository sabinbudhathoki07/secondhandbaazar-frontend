package com.sabin.sastofurniture.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ!\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/sabin/sastofurniture/repository/CustomerRepository;", "Lcom/sabin/sastofurniture/api/MyApiRequest;", "()V", "myApi", "Lcom/sabin/sastofurniture/api/CustomerAPI;", "getMyApi", "()Lcom/sabin/sastofurniture/api/CustomerAPI;", "getUserData", "Lcom/sabin/sastofurniture/response/UserProfileResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginUser", "Lcom/sabin/sastofurniture/response/LoginResponse;", "customer", "Lcom/sabin/sastofurniture/entity/Customer;", "(Lcom/sabin/sastofurniture/entity/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCustomer", "updateUserData", "id", "", "(Ljava/lang/String;Lcom/sabin/sastofurniture/entity/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class CustomerRepository extends com.sabin.sastofurniture.api.MyApiRequest {
    @org.jetbrains.annotations.NotNull()
    private final com.sabin.sastofurniture.api.CustomerAPI myApi = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.sabin.sastofurniture.api.CustomerAPI getMyApi() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object registerCustomer(@org.jetbrains.annotations.NotNull()
    com.sabin.sastofurniture.entity.Customer customer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.LoginResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object loginUser(@org.jetbrains.annotations.NotNull()
    com.sabin.sastofurniture.entity.Customer customer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.LoginResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.UserProfileResponse> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUserData(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    com.sabin.sastofurniture.entity.Customer customer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.UserProfileResponse> p2) {
        return null;
    }
    
    public CustomerRepository() {
        super();
    }
}