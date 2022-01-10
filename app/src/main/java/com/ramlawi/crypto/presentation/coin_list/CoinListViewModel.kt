package com.ramlawi.crypto.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramlawi.crypto.common.Resource
import com.ramlawi.crypto.domain.use_case.get_coins.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

/**
 * Created by Mohammed Alramlawi on 1/10/2022.
 */

/**
 *  we used viewmodel to maintain the view stat.
 */

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase
): ViewModel(){

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins(){
        getCoinsUseCase().onEach { result ->
            when(result){

                is Resource.Success ->{
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }

                is Resource.Error ->{
                    _state.value = CoinListState(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading ->{
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}