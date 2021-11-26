/**
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 *
 * Example 1:
 * Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,4,7,5,3,6,8,9]
 *
 * Example 2:
 * Input: mat = [[1,2],[3,4]]
 * Output: [1,2,3,4]
 *
 * Constraints:
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 */

/**
 * Complexity Analysis:
 * Time complexity : O(nxm).
 * Space complexity : O(n).
 *
 * Runtime: 710 ms, faster than 21.74% of Kotlin online submissions for Diagonal Traverse.
 * Memory Usage: 77 MB, less than 8.70% of Kotlin online submissions for Diagonal Traverse.
 */
private fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
    val tempMap = linkedMapOf<Int, MutableList<Int>>()
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            if (tempMap[i + j] != null) tempMap[i + j]!!.add(mat[i][j])
            else tempMap[i + j] = mutableListOf(mat[i][j])
        }
    }

    val result = mutableListOf<Int>()
    for (k in tempMap.keys) {
        if (k % 2 != 0) result.addAll(tempMap[k]!!)
        else result.addAll(tempMap[k]!!.reversed())
    }

    return result.toIntArray()
}

private fun main() {
    val example1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(10, 11, 12),
    )
    println(findDiagonalOrder(example1))

    val example2 = arrayOf(
        intArrayOf(477, 2647, -33),
        intArrayOf(289, 735, -277),
        intArrayOf(164, 5236, -320),
        intArrayOf(363, 1067, -306),
        intArrayOf(345, 483, -78),
        intArrayOf(307, 3905, 140),
        intArrayOf(260, 3676, 122),
        intArrayOf(195, 5003, 13),
        intArrayOf(331, 4447, 293),
        intArrayOf(40, 5282, 452),
        intArrayOf(335, 5225, 69),
        intArrayOf(128, 3733, -94),
        intArrayOf(186, 3251, -7),
        intArrayOf(245, 3908, 364),
        intArrayOf(278, 2093, 4),
        intArrayOf(334, 1553, 47),
        intArrayOf(459, 1267, 56),
        intArrayOf(399, 2584, 336),
        intArrayOf(411, 1136, 462),
        intArrayOf(428, 3119, 174),
        intArrayOf(317, 1050, -206),
        intArrayOf(303, 4985, 147),
        intArrayOf(429, 5453, -430),
        intArrayOf(132, 2588, -159),
        intArrayOf(351, 1119, 125),
        intArrayOf(116, 2360, -42),
        intArrayOf(72, 3934, -112),
        intArrayOf(486, 3681, 99),
        intArrayOf(153, 21, 329),
        intArrayOf(408, 3050, 75),
        intArrayOf(452, 2264, -13),
        intArrayOf(156, 2686, 205),
        intArrayOf(475, 838, -353),
        intArrayOf(420, 5311, 28),
        intArrayOf(265, 1870, 66),
        intArrayOf(502, 4905, 58),
        intArrayOf(99, 3282, 87),
        intArrayOf(143, 5092, -248),
        intArrayOf(512, 5357, -351),
        intArrayOf(272, 4311, 434),
        intArrayOf(458, 3121, 341),
        intArrayOf(225, 4819, -29),
        intArrayOf(493, 4613, -230),
        intArrayOf(99, 5133, -233),
        intArrayOf(97, 1897, 310),
        intArrayOf(508, 731, 389),
        intArrayOf(218, 1590, -143),
        intArrayOf(368, 2917, -311),
        intArrayOf(244, 1027, -130),
        intArrayOf(211, 5186, 155),
        intArrayOf(509, 3994, 38),
        intArrayOf(340, 2269, -9),
        intArrayOf(479, 3302, -358),
        intArrayOf(214, 3405, -213),
        intArrayOf(511, 2781, -285),
        intArrayOf(428, 481, 338),
        intArrayOf(222, 1628, -127),
        intArrayOf(480, 3728, -327),
        intArrayOf(176, 2755, 366),
        intArrayOf(182, 2682, -56),
        intArrayOf(446, 1498, -127),
        intArrayOf(172, 3842, -222),
        intArrayOf(192, 5507, -230),
        intArrayOf(30, 4423, 144),
        intArrayOf(186, 814, -64),
        intArrayOf(434, 689, -115),
        intArrayOf(128, 3875, 176),
        intArrayOf(179, 4241, 3),
        intArrayOf(34, 1224, 113),
        intArrayOf(285, 3759, -25),
        intArrayOf(345, 3123, -76),
        intArrayOf(481, 3800, 42),
        intArrayOf(478, 3587, 6),
        intArrayOf(315, 732, 315),
        intArrayOf(287, 986, -220),
        intArrayOf(285, 3605, 193),
        intArrayOf(381, 2592, 142),
        intArrayOf(405, 1911, 322),
        intArrayOf(388, 2085, -92),
        intArrayOf(193, 5521, 352),
        intArrayOf(131, 1606, -296),
        intArrayOf(518, 4054, -124),
        intArrayOf(224, 73, -30),
        intArrayOf(485, 463, -135),
        intArrayOf(1, 3975, 402),
        intArrayOf(29, 196, 289),
        intArrayOf(482, 4264, -123),
        intArrayOf(232, 4011, 38),
        intArrayOf(157, 2120, 68),
        intArrayOf(424, 1886, -103),
        intArrayOf(4, 508, -65),
        intArrayOf(50, 3198, 301),
        intArrayOf(101, 4824, -8),
        intArrayOf(316, 3283, -212),
        intArrayOf(484, 3025, -159),
        intArrayOf(113, 2315, -442),
        intArrayOf(186, 632, -100),
        intArrayOf(159, 5181, -155),
        intArrayOf(229, 1014, 166),
        intArrayOf(336, 3722, -223)
    )

    println(findDiagonalOrder(example2))
}