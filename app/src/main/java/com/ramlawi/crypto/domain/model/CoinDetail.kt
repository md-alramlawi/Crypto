package com.ramlawi.crypto.domain.model

import com.ramlawi.crypto.data.remote.dto.TeamMember

/**
 * Created by Mohammed Alramlawi on 1/9/2022.
 */

data class CoinDetail(
    val coinId: String,
    val name: String,
    val description: String,
    val symbol: String,
    val rank: Int,
    val isActive: Boolean,
    val tags: List<String>,
    val team: List<TeamMember>
)
