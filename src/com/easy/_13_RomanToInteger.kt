package com.easy

class _13_RomanToInteger {

    private val map = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )
    private val subtraction = mapOf(
        'V' to 'I',
        'X' to 'I',
        'L' to 'X',
        'C' to 'X',
        'D' to 'C',
        'M' to 'C',
    )

    fun romanToInt(s: String): Int {
        var res = 0
        var i = 0
        while (i < s.length) {
            val next: Char? = if (i < s.length - 1) {
                s[i + 1]
            } else {
                null
            }
            res += eval(s[i], next)
            if (subtraction[next] == s[i]) i++
            i++
        }
        return res
    }

    private fun eval(first: Char, second: Char?): Int {
        return if (subtraction[second] == first) {
            map[second]!!.minus(map[first]!!)
        } else {
            map[first]!!
        }
    }
}

fun main() {
    println(_13_RomanToInteger().romanToInt("LVIII"))
}
