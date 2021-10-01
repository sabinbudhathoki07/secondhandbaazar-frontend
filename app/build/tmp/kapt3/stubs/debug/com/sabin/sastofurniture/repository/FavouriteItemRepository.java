package com.sabin.sastofurniture.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0019\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/sabin/sastofurniture/repository/FavouriteItemRepository;", "Lcom/sabin/sastofurniture/api/MyApiRequest;", "()V", "FavouriteAPI", "Lcom/sabin/sastofurniture/api/CartApi;", "deleteAllFavouriteItem", "Lcom/sabin/sastofurniture/response/DeleteCartResponse;", "id", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteFavouriteItem", "getFavouriteItem", "Lcom/sabin/sastofurniture/response/FavouriteItemResponse;", "insertFavouriteItem", "cart", "Lcom/sabin/sastofurniture/entity/Cart;", "(Lcom/sabin/sastofurniture/entity/Cart;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class FavouriteItemRepository extends com.sabin.sastofurniture.api.MyApiRequest {
    private final com.sabin.sastofurniture.api.CartApi FavouriteAPI = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getFavouriteItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.FavouriteItemResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertFavouriteItem(@org.jetbrains.annotations.NotNull()
    com.sabin.sastofurniture.entity.Cart cart, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.FavouriteItemResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteFavouriteItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.DeleteCartResponse> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAllFavouriteItem(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.sabin.sastofurniture.response.DeleteCartResponse> p1) {
        return null;
    }
    
    public FavouriteItemRepository() {
        super();
    }
}