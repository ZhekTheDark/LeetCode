package com.easy

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 *
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * Constraints:
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Complexity Analysis
 * Time complexity : O(n + m).
 * Space complexity : O(1).
 *
 * Runtime: 169 ms, faster than 63.5% of Kotlin online submissions for Merge Two Sorted Lists.
 * Memory Usage: 35.4 MB, less than 77.1% of Kotlin online submissions for Merge Two Sorted Lists.
 */
fun mergeTwoListsSlow(list1: ListNode?, list2: ListNode?): ListNode? {
    var node1 = list1
    var node2 = list2
    val head = when (whichMinListNode(node1, node2)) {
        INDICES.FIRST -> {
            val value = node1
            node1 = node1?.next
            value
        }
        INDICES.SECOND -> {
            val value = node2
            node2 = node2?.next
            value
        }
    }
    var node = head
    while (node1 != null || node2 != null) {
        val nextNode = when (whichMinListNode(node1, node2)) {
            INDICES.FIRST -> {
                val value = node1
                node1 = node1?.next
                value
            }
            INDICES.SECOND -> {
                val value = node2
                node2 = node2?.next
                value
            }
        }
        node?.next = nextNode
        node = node?.next
    }
    return head
}

enum class INDICES { FIRST, SECOND}

private fun whichMinListNode(first: ListNode?, second: ListNode?): INDICES {
    return if ((first?.`val` ?: Int.MAX_VALUE) <= (second?.`val` ?: Int.MAX_VALUE)) {
        INDICES.FIRST
    } else {
        INDICES.SECOND
    }
}

/**
 * Complexity Analysis
 * Time complexity : O(n + m).
 * Space complexity : O(1).
 *
 * Runtime: 154 ms, faster than 95.31% of Kotlin online submissions for Merge Two Sorted Lists.
 * Memory Usage: 35 MB, less than 92.86% of Kotlin online submissions for Merge Two Sorted Lists.
 */
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    return when {
        list1 == null && list2 == null -> {
            null
        }
        list1 == null -> {
            list2
        }
        list2 == null -> {
            list1
        }
        else -> {
            if (list1.`val` < list2.`val`) {
                list1.next = mergeTwoLists(list1.next, list2)
                list1
            } else {
                list2.next = mergeTwoLists(list1, list2.next)
                list2
            }
        }
    }
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

fun assertEquals(expected: ListNode?, actual: ListNode?) {
    var tempExpected: ListNode? = expected
    var tempActual: ListNode? = actual
    do {
        if (tempExpected?.`val` != tempActual?.`val`) {
            throw RuntimeException("nodes are not equal")
        } else {
            tempExpected = tempExpected?.next
            tempActual = tempActual?.next
        }
    } while (tempExpected != null)
}

fun ListNode.joinToString(delimiter: String = " ", start: String = "(", end: String = ")") {
    print(start)
    do {
        print("${this.`val`}$delimiter")
    } while (this.next != null)
    print(end)
}
