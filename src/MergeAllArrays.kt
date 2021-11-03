import kotlin.random.Random

private fun mergeAllArrays(entryArray: Array<IntArray>): IntArray {
    val resultArray = mutableListOf<Int>()
    val arrayIndexes = IntArray(entryArray.size)
    var min: Int
    val allSize = entryArray.fold(0) {acc, a -> acc + a.size}

    for (j in 0 until allSize) {
        min = Int.MAX_VALUE
        var cursor = 0
        for (i in entryArray.indices) {
            if (arrayIndexes[i] >= entryArray[i].size) continue
            if (min > entryArray[i][arrayIndexes[i]]) {
                min = entryArray[i][arrayIndexes[i]]
                cursor = i
            }
        }
        arrayIndexes[cursor]++
        resultArray.add(min)
    }

    return resultArray.toIntArray()
}

fun main() {
    val countArray = Random.nextInt(5, 10)
    val arrays: MutableList<IntArray> = mutableListOf()
    for (i in 0..countArray) {
        val sizeArray = Random.nextInt(0, 5)
        val a = IntArray(sizeArray) { Random.nextInt(0, 100) }
        a.sort()
        arrays.add(a)
    }
    val arraysForCheck = arrays.toTypedArray()

    println(arraysForCheck.joinToString("\n") { it.joinToString(",") })

    val result = mergeAllArrays(arraysForCheck)

    println()
    println(result.joinToString(","))
}