package com.example.ahmedretrofitmobs.data

import com.example.ahmedretrofitmobs.data.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductsRepository {
    suspend fun getProductsList(): Flow<Result<List<Product>>>
}