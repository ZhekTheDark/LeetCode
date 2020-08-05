/**
 * Quick sort
 *
 * Быстрая сортировка
 *
 * Complexity Analysis:
 * Time complexity : O(n*log(n)).
 * Space complexity : O(1).
 */

private fun quickSort(array: IntArray, start: Int, end: Int) {

    if (start < end) {
        val q = partition(array, start, end)
        quickSort(array, start, q - 1)
        quickSort(array, q + 1, end)
    }

}

private fun partition(array: IntArray, start: Int, end: Int): Int {

    val x = array[end]
    var i = start - 1

    for (j in start until end) {
        if (array[j] < x) {
            i++
            val temp = array[i]
            array[i] = array[j]
            array[j] = temp
        }
    }

    val temp = array[i + 1]
    array[i + 1] = array[end]
    array[end] = temp

    return (i + 1)

}

fun main() {

    val array = intArrayOf(2, 8, 7, 1, 3, 5, 6, 4)

    println("Before QuickSort\n ${array.joinToString()}")

    quickSort(array, 0, array.size - 1)

    println("\nAfter QuickSort\n ${array.joinToString()}")

}
