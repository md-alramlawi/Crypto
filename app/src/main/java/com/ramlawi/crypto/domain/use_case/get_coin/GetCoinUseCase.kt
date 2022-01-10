package com.ramlawi.crypto.domain.use_case.get_coin

import com.ramlawi.crypto.common.Resource
import com.ramlawi.crypto.data.remote.dto.toCoinDetail
import com.ramlawi.crypto.domain.model.CoinDetail
import com.ramlawi.crypto.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

class GetCoinUseCase @Inject constructor(
    /**
     * take care you don't inject CoinRepositoryImpl,
     * you want to inject the interface because that allows it to be easily replaceable
     */

    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String) : Flow<Resource<CoinDetail>>  = flow{
        try {
            emit(Resource.Loading<CoinDetail>())
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success<CoinDetail>(coin))
        }catch (e: HttpException){
            emit(Resource.Error<CoinDetail>(e.localizedMessage ?: "An Unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Error<CoinDetail>("No internet connection !!"))
        }
    }
}