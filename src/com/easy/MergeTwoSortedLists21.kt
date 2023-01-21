package com.easy

import kotlin.math.min
import kotlin.test.assertEquals

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
//private fun getMinListNode(list1: ListNode?, list2: ListNode?): ListNode? {
//    return if ((list1?.`val` ?: Int.MAX_VALUE) <= (list2?.`val` ?: Int.MAX_VALUE)) {
//        list1
//    } else {
//        list2
//    }
//}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = getMinListNode(list1, list2)

}

fun main() {
    Input: list1 = [1,2,4], list2 = [1,3,4]
    Output: [1,1,2,3,4,4]

    val node13 = ListNode(4).apply { next = null }
    val node12 = ListNode(2).apply { next = node13 }
    val node11 = ListNode(1).apply { next = node12 }

    val node23 = ListNode(4).apply { next = null }
    val node22 = ListNode(2).apply { next = node23 }
    val node21 = ListNode(1).apply { next = node22 }


    val expectedListNode6 = ListNode(1).apply { next = null }
    val expectedListNode =
    assertEquals()
}