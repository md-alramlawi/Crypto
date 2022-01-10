package com.ramlawi.crypto.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ramlawi.crypto.domain.model.Coin

/**
 * Created by Mohammed Alramlawi on 1/10/2022.
 */

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ){
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = if(coin.isActive) "active" else "inactive",
            color = if(coin.isActive) MaterialTheme.colors.primary else Color.Red,
            fontStyle = FontStyle.Italic,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(CenterVertically)
        )
    }
}