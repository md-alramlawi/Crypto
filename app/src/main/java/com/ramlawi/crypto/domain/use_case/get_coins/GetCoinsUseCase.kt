package com.ramlawi.crypto.domain.use_case.get_coins

import com.ramlawi.crypto.common.Resource
import com.ramlawi.crypto.data.remote.dto.toCoin
import com.ramlawi.crypto.domain.model.Coin
import com.ramlawi.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

class GetCoinsUseCase @Inject constructor(
    /**
     * take care you don't inject CoinRepositoryImpl,
     * you want to inject the interface because that allows it to be easily replaceable
     */

    private val repository: CoinRepository
) {
    operator fun invoke() : Flow<Resource<List<Coin>>>  = flow{
        try {
            emit(Resource.Loading<List<Coin>>())
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))
        }catch (e: HttpException){
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<List<Coin>>("No internet connection !!"))
        }
    }
}