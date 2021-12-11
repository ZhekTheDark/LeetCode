package com.easy

fun largestOddNumber(num: String): String {
    return num.dropLastWhile { Character.getNumericValue(it) % 2 == 0 }
}