package com.sabin.sastofurniture.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J!\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J5\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0010\u001a\u00020\u000b2\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/sabin/sastofurniture/api/CustomerAPI;", "", "checkUser", "Lretrofit2/Response;", "Lcom/sabin/sastofurniture/response/LoginResponse;", "customer", "Lcom/sabin/sastofurniture/entity/Customer;", "(Lcom/sabin/sastofurniture/entity/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUser", "Lcom/sabin/sastofurniture/response/UserProfileResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerCustomer", "user", "updateUser", "id", "(Ljava/lang/String;Ljava/lang/String;Lcom/sabin/sastofurniture/entity/Customer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CustomerAPI {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "customers/signup")
    public abstract java.lang.Object registerCustomer(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.sabin.sastofurniture.entity.Customer user, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sabin.sastofurniture.response.LoginResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "customer/login")
    public abstract java.lang.Object checkUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.sabin.sastofurniture.entity.Customer customer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sabin.sastofurniture.response.LoginResponse>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.PUT(value = "customer/update/{id}")
    public abstract java.lang.Object updateUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "id")
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    com.sabin.sastofurniture.entity.Customer customer, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sabin.sastofurniture.response.UserProfileResponse>> p3);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "customer/account")
    public abstract java.lang.Object getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Header(value = "Authorization")
    java.lang.String token, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.sabin.sastofurniture.response.UserProfileResponse>> p1);
}