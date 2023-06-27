package com.easy

class _13_RomanToInteger {

    fun romanToInt(s: String): Int {
        var res = 0
        val map = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )
        val subtraction = mapOf(

        )

        for ((index, char) in s.withIndex()) {
            val next = if (index < s.length - 1) {
                s[index + 1]
            } else {
                null
            }
            if (char)
        }

        return res
    }

    fun eval(first: Int, second: Int?): Int {

    }
}
