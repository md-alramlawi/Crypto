package com.ramlawi.crypto.data.remote

import com.ramlawi.crypto.data.remote.dto.CoinDetailDto
import com.ramlawi.crypto.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}