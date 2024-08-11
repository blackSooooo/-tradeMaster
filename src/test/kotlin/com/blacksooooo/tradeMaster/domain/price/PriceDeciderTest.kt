package com.blacksooooo.tradeMaster.domain.price

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PriceDeciderTest {
    @Test
    fun `상한가의 경우 시초가보다 30% 높은 가격으로 결정된다`() {
        val openingPrice = 1000
        val upperLimitPrice = 1300

        val actual = PriceDecider.decideUpperLimitPrice(openingPrice)

        actual shouldBe upperLimitPrice
    }

    @Test
    fun `하한가의 경우 시초가보다 30% 낮은 가격으로 결정된다`() {
        val openingPrice = 1000
        val lowerLimitPrice = 700

        val actual = PriceDecider.decideLowerLimitPrice(openingPrice)

        actual shouldBe lowerLimitPrice
    }

    @Test
    fun `상한가 계산값이 소수인 경우 내림값으로 결정된다`() {
        val openingPrice = 1001
        val upperLimitPrice = 1301

        val actual = PriceDecider.decideUpperLimitPrice(openingPrice)

        actual shouldBe upperLimitPrice
    }

    @Test
    fun `하한가 계산값이 소수인 경우 올림값으로 결정된다`() {
        val openingPrice = 1001
        val lowerLimitPrice = 701

        val actual = PriceDecider.decideLowerLimitPrice(openingPrice)

        actual shouldBe lowerLimitPrice
    }
}