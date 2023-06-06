package com.medium

import java.util.*

class _901_OnlineStockSpan {

    private val stack = Stack<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var days = 1
        while (stack.isNotEmpty() && (stack.peek().first <= price)) {
            days += stack.pop().second
        }
        stack.push(price to days)
        return days
    }
}
