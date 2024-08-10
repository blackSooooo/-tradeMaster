package com.blacksooooo.tradeMaster.domain.price

import org.slf4j.LoggerFactory
import kotlin.math.ceil
import kotlin.math.floor

object PriceDecider {
    private const val STANDARD = 1
    private const val UPPER_LIMIT = 0.3
    private const val LOWER_LIMIT = 0.3

    private const val UNDER_2_000_PRICE_TICK = 1
    private const val UNDER_5_000_PRICE_TICK = 5
    private const val UNDER_20_000_PRICE_TICK = 10
    private const val UNDER_50_000_PRICE_TICK = 50
    private const val UNDER_200_000_PRICE_TICK = 100
    private const val UNDER_500_000_PRICE_TICK = 500
    private const val OVER_500_000_PRICE_TICK = 1_000
    private val logger = LoggerFactory.getLogger(javaClass)


    /**
     * 상한가의 경우, 시초가 대비 1.3을 곱하고 내림 가격을 return 한다.
     */
    fun decideUpperLimitPrice(openingPrice: Int): Int {
        return floor(openingPrice * (STANDARD + UPPER_LIMIT)).toInt()
    }

    /**
     * 하한가의 경우, 시초가 대비 0.7을 곱하고 올림 가격을 return 한다.
     */
    fun decideLowerLimitPrice(openingPrice: Int): Int {
        return ceil(openingPrice * (STANDARD - LOWER_LIMIT)).toInt()
    }

    /**
     * 하한가, 상한가를 기준으로 호가 가격이 담긴 List를 return 한다.
     */
    fun decidePriceRange(lowerLimitPrice: Int, upperLimitPrice: Int): List<Int> {
        return generateSequence(lowerLimitPrice) { it + decideTickPrice(it) }
            .takeWhile { it <= upperLimitPrice }
            .toList()
    }

    private fun decideTickPrice(price: Int): Int {
        if (price < 2000) {
            return UNDER_2_000_PRICE_TICK
        }
        if (price < 5000) {
            return UNDER_5_000_PRICE_TICK
        }
        if (price < 20000) {
            return UNDER_20_000_PRICE_TICK
        }
        if (price < 50000) {
            return UNDER_50_000_PRICE_TICK
        }
        if (price < 200000) {
            return UNDER_200_000_PRICE_TICK
        }
        if (price < 500000) {
            return UNDER_500_000_PRICE_TICK
        }
        return OVER_500_000_PRICE_TICK
    }
}