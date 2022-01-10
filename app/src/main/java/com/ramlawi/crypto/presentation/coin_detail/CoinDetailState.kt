package com.ramlawi.crypto.presentation.coin_detail

import com.ramlawi.crypto.domain.model.CoinDetail

/**
 * Created by Mohammed Alramlawi on 1/10/2022.
 */

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
