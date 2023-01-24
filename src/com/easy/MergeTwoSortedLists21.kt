package com.easy

import kotlin.test.assertEquals

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

private fun getMinListNodeValue(list1: ListNode?, list2: ListNode?): Int? {
    return if ((list1?.`val` ?: Int.MAX_VALUE) <= (list2?.`val` ?: Int.MAX_VALUE)) {
        list1?.`val`
    } else {
        list2?.`val`
    }
}

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val head = getMinListNodeValue(list1, list2)?.let { ListNode(it) }
    var node = getMinListNodeValue(list1, list2)

    while (list1!=null && list2!=null) {
        var nextNode = getMinListNodeValue(list1, list2)
    }

    return head
}

fun main() {
    val node13 = ListNode(4).apply { next = null }
    val node12 = ListNode(2).apply { next = node13 }
    val node11 = ListNode(1).apply { next = node12 }

    val node23 = ListNode(4).apply { next = null }
    val node22 = ListNode(3).apply { next = node23 }
    val node21 = ListNode(1).apply { next = node22 }

    val expectedListNode6 = ListNode(4).apply { next = null }
    val expectedListNode5 = ListNode(4).apply { next = expectedListNode6 }
    val expectedListNode4 = ListNode(3).apply { next = expectedListNode5 }
    val expectedListNode3 = ListNode(2).apply { next = expectedListNode4 }
    val expectedListNode2 = ListNode(1).apply { next = expectedListNode3 }
    val expectedListNode1 = ListNode(1).apply { next = expectedListNode2 }

    val actualListNode = mergeTwoLists(node11, node21)
    assertEquals(expectedListNode1, actualListNode)
}

fun assertEquals(expected: ListNode, actual: ListNode): Boolean {
    var tempExpected: ListNode? = expected
    var tempActual: ListNode? = actual
    do {
        if (tempExpected?.`val` != tempActual?.`val`) {
            return false
        } else {
            tempExpected = tempExpected?.next
            tempActual = tempActual?.next
        }
    } while (expected.next != null)

    return true
}
