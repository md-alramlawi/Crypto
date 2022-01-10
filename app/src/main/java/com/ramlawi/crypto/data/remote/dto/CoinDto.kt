package com.ramlawi.crypto.data.remote.dto

import com.ramlawi.crypto.domain.model.Coin

data class CoinDto(
    val id: String,
    val is_active: Boolean,
    val is_new: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)

fun CoinDto.toCoin(): Coin{
    return Coin(
        id = id,
        isActive = is_active,
        name = name,
        rank = rank,
        symbol = symbol
    )
}