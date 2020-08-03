/**
 * Insertion sort
 *
 * Сортировка вставками
 *
 * Complexity Analysis:
 * Time complexity : O(n^2).
 * Space complexity : O(1).
 */

private fun insertionSort(array: IntArray) {

    for (j in 1 until array.size) {
        val key = array[j]
        var i = j - 1
        while (i >= 0 && array[i] > key) {
            array[i + 1] = array[i]
            i--
        }
        array[i + 1] = key
    }

}

fun main() {

    val array = intArrayOf(5, 2, 4, 6, 1, 3)

    println("Before InsertionSort\n ${array.joinToString()}")

    insertionSort(array)

    println("\nAfter InsertionSort\n ${array.joinToString()}")
}
