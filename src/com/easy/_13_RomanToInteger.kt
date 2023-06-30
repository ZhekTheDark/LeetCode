package com.easy

class _13_RomanToInteger {

    fun romanToInt(s: String): Int {
        var res = 0
        val map = mapOf<Char, Int>(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000,
        )
        val subtraction = mapOf(
            'V' to 'I',
            'X' to 'I',
            'L' to 'X',
            'C' to 'X',
            'D' to 'C',
            'M' to 'C',
        )

        var i = 0
        while (i < s.length) {
            val next: Int? = if (i < s.length - 1) {
                s[i + 1]
                i++
            } else {
                null
            }
            res += eval(map[s[i]]!!, map.get(next))
            i++
        }

        return res
    }

    fun eval(first: Int, second: Int?): Int {

    }
}
