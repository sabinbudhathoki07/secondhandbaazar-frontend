package com.sabin.sastofurniture

import com.sabin.sastofurniture.api.ServiceBuilder
import com.sabin.sastofurniture.entity.Cart
import com.sabin.sastofurniture.entity.Customer
import com.sabin.sastofurniture.repository.CustomerRepository
import com.sabin.sastofurniture.repository.FavouriteItemRepository
import com.sabin.sastofurniture.repository.ProductRepository
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class Testing {
    private lateinit var customerRepository: CustomerRepository
    private lateinit var favouriteitemrepository: FavouriteItemRepository
    private lateinit var productRepository: ProductRepository

    @Test
    fun checkLoginTest() = runBlocking {
        customerRepository = CustomerRepository()
        val customer = Customer(
                email = "sabin123@gmail.com",
                password = "sabin123"
        )
        val response = customerRepository.loginUser(customer)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun checkSignUpTest() = runBlocking {
        customerRepository = CustomerRepository()
        val customer = Customer(
                fullname = "Sabin Budhathoki",
                email = "sabina1234567891016188@gmail.com",
                password = "sabin123",
                mobileno = "9811328418"
        )
        val response = customerRepository.registerCustomer(customer)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)
    }


    @Test
    fun deleteProduct() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        favouriteitemrepository = FavouriteItemRepository()
        val id = "606d732a7ab675055884f3dd"
        val response = favouriteitemrepository.deleteFavouriteItem(id)
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)
    }


    @Test
    fun updateUserCheck() = runBlocking {
        customerRepository = CustomerRepository()
        val login = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(login).token
        val customer = Customer(fullname = "rajan", mobileno = "9844478291")
        val userid = "6077d0dba8fdde24387a6780"
        val response = customerRepository.updateUserData(userid, customer)
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)

    }


    @Test
    fun getUserCheck() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        val response = customerRepository.getUserData()
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)
    }


    @Test
    fun singleItem() = runBlocking {

        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        productRepository = ProductRepository()
        val id = "6077d3e1a8fdde24387a6782"
        val response = productRepository.singleIteam(id)
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)
    }


    @Test
    fun getFavouriteItem() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        favouriteitemrepository = FavouriteItemRepository()
        val id = "6077d3e1a8fdde24387a6782"
        val response = favouriteitemrepository.getFavouriteItem(id)
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)
    }

    @Test
    fun insertFavouriteItem() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        customerRepository = CustomerRepository()
        val product = Cart(
                CartItemid = "chair",
                CartItemUser = "home",

                )
        val response = FavouriteItemRepository().insertFavouriteItem(cart = product)
        val expectedResult = true
        val actualResult = response.success
        Assert.assertEquals(expectedResult, actualResult)


    }

    @Test
    fun getProduct() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        productRepository = ProductRepository()
        val response = productRepository.getProduct()
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)


    }

    @Test
    fun getProductById() = runBlocking {
        customerRepository = CustomerRepository()
        val userlogin = Customer(email = "sabin123@gmail.com", password = "sabin123")
        ServiceBuilder.token = "Bearer " + customerRepository.loginUser(userlogin).token
        productRepository = ProductRepository()
        val response = productRepository.getProductById()
        val expectedResult = true
        val actualResult = response.success
        org.junit.Assert.assertEquals(expectedResult, actualResult)

    }
}