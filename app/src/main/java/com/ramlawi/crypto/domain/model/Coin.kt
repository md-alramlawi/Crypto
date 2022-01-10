package com.ramlawi.crypto.domain.model

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

data class Coin(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
