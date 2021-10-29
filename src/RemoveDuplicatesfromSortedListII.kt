/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * Return the linked list sorted as well.
 *
 * Нужно брать все повторяющиеся елементы отсортированного списка
 *
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
 */

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 160 ms, faster than 100.00% of Kotlin online submissions for Remove Duplicates from Sorted List II.
 * Memory Usage: 34.3 MB, less than 92.59% of Kotlin online submissions for Remove Duplicates from Sorted List II.
 */
private fun deleteDuplicates(head: ListNode?): ListNode? {

    val result = ListNode(0).apply { next = head }
    var prevHead = result
    var lastDuplicateValue: Int? = null

    while (prevHead.next != null) {
        val currHead = prevHead.next!!

        if (currHead.`val` == currHead.next?.`val` || lastDuplicateValue == currHead.`val`) {
            lastDuplicateValue = currHead.`val`
            prevHead.next = currHead.next
        } else {
            prevHead = currHead
        }
    }

    return result.next

}

fun main() {

    val listNode17 = ListNode(5)
    val listNode16 = ListNode(4).apply { next = listNode17 }
    val listNode15 = ListNode(4).apply { next = listNode16 }
    val listNode14 = ListNode(3).apply { next = listNode15 }
    val listNode13 = ListNode(3).apply { next = listNode14 }
    val listNode12 = ListNode(2).apply { next = listNode13 }
    val listNode11 = ListNode(1).apply { next = listNode12 }

//    println(deleteDuplicates(listNode11)?.joinToString() ?: "null")

}