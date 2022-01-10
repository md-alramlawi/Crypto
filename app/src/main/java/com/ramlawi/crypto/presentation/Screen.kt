package com.ramlawi.crypto.presentation

/**
 * Created by Mohammed Alramlawi on 1/10/2022.
 */

sealed class Screen (val rout: String){
    object CoinListScreen: Screen("coin_list_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}