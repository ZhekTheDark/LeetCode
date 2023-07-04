package com.easy

fun longestCommonPrefix(strs: Array<String>): String {
    val w = strs[0]
    w.forEachIndexed { index, c ->
        if (strs.any { it.length == index } || strs.any { it[index] != c }) return w.substring(0, index)
    }
    return w
}