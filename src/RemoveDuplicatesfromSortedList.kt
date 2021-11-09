/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 *
 */
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 172 ms, faster than 94.83% of Kotlin online submissions for Remove Duplicates from Sorted List.
 * Memory Usage: 34.2 MB, less than 56.90% of Kotlin online submissions for Remove Duplicates from Sorted List.
 */
private fun deleteDuplicates(head: ListNode): ListNode? {
    val result = ListNode(0).apply { next = head }
    var previouslyNode = result

    while (previouslyNode.next != null) {
        val currentNode = previouslyNode.next!!

        if (currentNode.`val` == currentNode.next?.`val`) {
            previouslyNode.next = currentNode.next
        } else {
            previouslyNode = currentNode
        }
    }

    return result.next
}

/**
 * Complexity Analysis
 * Time complexity : O(n).
 * Space complexity : O(1).
 *
 * Runtime: 164 ms, faster than 98.28% of Kotlin online submissions for Remove Duplicates from Sorted List.
 * Memory Usage: 34.1 MB, less than 63.79% of Kotlin online submissions for Remove Duplicates from Sorted List.
 */
/*private fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head?.next == null) return head

    var temp = head

    while (temp?.next != null) {
        if (temp.`val` == temp.next!!.`val`) {
            temp.next = temp.next!!.next
        } else {
            temp = temp.next
        }
    }

    return head
}*/


fun main() {
    val listNode17 = ListNode(5)
    val listNode16 = ListNode(4).apply { next = listNode17 }
    val listNode15 = ListNode(4).apply { next = listNode16 }
    val listNode14 = ListNode(3).apply { next = listNode15 }
    val listNode13 = ListNode(3).apply { next = listNode14 }
    val listNode12 = ListNode(2).apply { next = listNode13 }
    val listNode11 = ListNode(1).apply { next = listNode12 }

    val listNode25 = ListNode(3)
    val listNode24 = ListNode(3).apply { next = listNode25 }
    val listNode23 = ListNode(2).apply { next = listNode24 }
    val listNode22 = ListNode(1).apply { next = listNode23 }
    val listNode21 = ListNode(1).apply { next = listNode22 }

//    println(deleteDuplicates(listNode11).joinToString() ?: "null")
//    println(deleteDuplicates(listNode21).joinToString() ?: "null")
}