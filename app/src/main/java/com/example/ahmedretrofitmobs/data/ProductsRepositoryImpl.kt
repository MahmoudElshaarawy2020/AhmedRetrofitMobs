package com.example.ahmedretrofitmobs.data

import com.example.ahmedretrofitmobs.data.model.Product
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class ProductsRepositoryImpl(private val api: Api): ProductsRepository {
    override suspend fun getProductsList(): Flow<Result<List<Product>>> {
        return flow {
            val productFromApi = try {
                api.getProductsList()
            } catch(e: IOException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            } catch(e: HttpException){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            } catch(e: Exception){
                e.printStackTrace()
                emit(Result.Error(message = "Error loading products"))
                return@flow
            }
            emit(Result.Success(productFromApi.products))
        }
    }
}