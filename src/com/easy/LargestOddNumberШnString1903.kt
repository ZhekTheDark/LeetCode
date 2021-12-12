package com.easy

import kotlin.test.assertEquals

fun largestOddNumber(num: String): String {
    return num.dropLastWhile { Character.getNumericValue(it) % 2 == 0 }
}

fun main() {
    val example1Num = "52"
    assertEquals("5", largestOddNumber(example1Num), "LargestOddNumberШnString1903 example1 error")
}
