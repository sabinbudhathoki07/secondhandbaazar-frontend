package com.sabin.sastofurniture.repository

import com.sabin.sastofurniture.api.CartApi
import com.sabin.sastofurniture.api.MyApiRequest
import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.Cart
import com.sabin.sastofurniture.response.DeleteCartResponse
import com.sabin.sastofurniture.response.FavouriteItemResponse
import com.sabin.sastofurniture.response.GetCartResponse

class FavouriteItemRepository : MyApiRequest(){
        private  val FavouriteAPI = ServiceBuilder.buildService(CartApi::class.java)
        suspend fun getFavouriteItem(id: String): FavouriteItemResponse {
            return apiRequest {
                FavouriteAPI.getFavouriteItem(ServiceBuilder.token!!,id)
            }
        }
        suspend fun insertFavouriteItem(cart: Cart): FavouriteItemResponse{
            return  apiRequest {
                FavouriteAPI.insertFavoutiteItem(ServiceBuilder.token!!,cart)
            }
        }
        suspend fun deleteFavouriteItem(id: String): DeleteCartResponse{
            return apiRequest {
                FavouriteAPI.deleteFavouriteItem(ServiceBuilder.token!!,id)
            }
        }

    suspend fun deleteAllFavouriteItem(id: String): DeleteCartResponse{
        return apiRequest {
            FavouriteAPI.deleteAllFavouriteItem(ServiceBuilder.token!!,id)
        }
    }
}