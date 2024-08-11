package com.blacksooooo.tradeMaster.domain.market

import java.util.LinkedList

/**
 * 매수를 하는 경우 -> 시장가로 긁을 수 있음. 혹은 매수호가에 걸어놓을 수 있음.
 * 매도를 하는 경우 -> 시장가로 던질 수 있음. 혹은 매도호가에 걸어놓을 수 있음.
 *
 * 결국 해당 데이터 클래스는 한 시점의 스냅샷이라고 생각했을 때, 우선 당장은 buyOrder만 있거나 sellOrder만 있을 수 밖에 없음
 */
data class StockPrice(
    val price: Int,
    val buyOrderBook: LinkedList<Order>,
    val sellOrderBook: LinkedList<Order>,
    val orderMap: HashMap<String, Order>,
    val orderQuantity: Int
)