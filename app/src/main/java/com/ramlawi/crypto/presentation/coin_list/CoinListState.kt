package com.ramlawi.crypto.presentation.coin_list

import com.ramlawi.crypto.domain.model.Coin

/**
 * Created by Mohammed Alramlawi on 1/10/2022.
 */

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
