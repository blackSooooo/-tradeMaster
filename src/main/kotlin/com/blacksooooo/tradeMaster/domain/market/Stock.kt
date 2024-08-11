package com.blacksooooo.tradeMaster.domain.market

data class Stock(
    val id: String,
    val currentMarketPrice: Int,
    val priceMap: HashMap<Int, StockPrice>,
    val buyOrderQuantity: Long,
    val sellOrderQuantity: Long
)
