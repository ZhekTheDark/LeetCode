package sorting

/**
 * Merge sort
 *
 * Сортировка слиянием
 *
 * Complexity Analysis:
 * Time complexity : O(n*log(n)).
 * Space complexity : O(n).
 */
private fun mergeSort(array: IntArray, start: Int, end: Int) {
    if (start < end) {
        val middle = (start + end) / 2
        mergeSort(array, start, middle)
        mergeSort(array, middle + 1, end)
        merge(array, start, middle, end)
    }
}

private fun merge(array: IntArray, start: Int, middle: Int, end: Int) {
    val leftSize = middle - start + 1
    val rightSize = end - middle
    val leftSubArray = mutableListOf<Int>()
    val rightSubArray = mutableListOf<Int>()

    for (i in 0 until leftSize)
        leftSubArray.add(array[start + i])
    for (i in 0 until rightSize)
        rightSubArray.add(array[middle + i + 1])

    leftSubArray.add(Int.MAX_VALUE)
    rightSubArray.add(Int.MAX_VALUE)
    var i = 0
    var j = 0

    for (k in start..end) {
        if (leftSubArray[i] <= rightSubArray[j]) {
            array[k] = leftSubArray[i]
            i++
        } else {
            array[k] = rightSubArray[j]
            j++
        }
    }
}

fun main() {
    val array = intArrayOf(5, 8, 2, 4, 7, 6, 1, 3)

    println("Before MergeSort\n ${array.joinToString()}")

    mergeSort(array, 0, array.size - 1)

    println("\nAfter MergeSort\n ${array.joinToString()}")
}
