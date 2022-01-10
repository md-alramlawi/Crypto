package com.ramlawi.crypto.domain.repository

import com.ramlawi.crypto.data.remote.dto.CoinDetailDto
import com.ramlawi.crypto.data.remote.dto.CoinDto

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}