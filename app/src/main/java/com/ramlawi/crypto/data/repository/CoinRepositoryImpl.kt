package com.ramlawi.crypto.data.repository

import com.ramlawi.crypto.data.remote.CoinApi
import com.ramlawi.crypto.data.remote.dto.CoinDetailDto
import com.ramlawi.crypto.data.remote.dto.CoinDto
import com.ramlawi.crypto.domain.repository.CoinRepository
import javax.inject.Inject

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
): CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}