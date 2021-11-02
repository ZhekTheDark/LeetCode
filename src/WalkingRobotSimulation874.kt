import kotlin.test.assertEquals

/**
 * A robot on an infinite XY-plane starts at point (0, 0) facing north. The robot can receive a sequence of these three
 * possible types of commands:
 *
 * -2: Turn left 90 degrees.
 * -1: Turn right 90 degrees.
 * 1 <= k <= 9: Move forward k units, one unit at a time.
 *
 * Some of the grid squares are obstacles. The ith obstacle is at grid point obstacles[i] = (xi, yi). If the robot runs
 * into an obstacle, then it will instead stay in its current location and move on to the next command.
 *
 * Return the maximum Euclidean distance that the robot ever gets from the origin squared
 * (i.e. if the distance is 5,return 25).
 *
 * Note:
 * North means +Y direction.
 * East means +X direction.
 * South means -Y direction.
 * West means -X direction.
 *
 * Example 1:
 *
 * Input: commands = [4,-1,3], obstacles = []
 * Output: 25
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 3 units to (3, 4).
 * The furthest point the robot ever gets from the origin is (3, 4), which squared is 32 + 42 = 25 units away.
 * Example 2:
 *
 * Input: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * Output: 65
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 4 units to (0, 4).
 * 2. Turn right.
 * 3. Move east 1 unit and get blocked by the obstacle at (2, 4), robot is at (1, 4).
 * 4. Turn left.
 * 5. Move north 4 units to (1, 8).
 * The furthest point the robot ever gets from the origin is (1, 8), which squared is 12 + 82 = 65 units away.
 * Example 3:
 *
 * Input: commands = [6,-1,-1,6], obstacles = []
 * Output: 36
 * Explanation: The robot starts at (0, 0):
 * 1. Move north 6 units to (0, 6).
 * 2. Turn right.
 * 3. Turn right.
 * 4. Move south 6 units to (0, 0).
 * The furthest point the robot ever gets from the origin is (0, 6), which squared is 62 = 36 units away.
 *
 * Constraints:
 *
 * 1 <= commands.length <= 10^4
 * commands[i] is either -2, -1, or an integer in the range [1, 9].
 * 0 <= obstacles.length <= 10^4
 * -3 * 10^4 <= xi, yi <= 3 * 10^4
 * The answer is guaranteed to be less than 2^31.
 */
private fun walkingRobotSimulation874(commands: IntArray, obstacles: Array<IntArray>): Int {
    val searchableObstacles = obstacles.map { Pair(it[0], it[1]) }.toSet()
    var x = 0
    var y = 0
    var direction = 0
    var maxDistance = 0

    for (command in commands) {
        when (command) {
            -1 -> direction = (1 + direction) % 4
            -2 -> direction = (3 + direction) % 4
            else -> repeat(command) {
                when (direction) {
                    0 -> if (!searchableObstacles.contains(Pair(x, y + 1))) y++
                    1 -> if (!searchableObstacles.contains(Pair(x + 1, y))) x++
                    2 -> if (!searchableObstacles.contains(Pair(x, y - 1))) y--
                    3 -> if (!searchableObstacles.contains(Pair(x - 1, y))) x--
                }
                maxDistance = maxOf(maxDistance, x * x + y * y)
            }
        }
    }

    return maxDistance
}

private fun main() {
    val commands1 = intArrayOf(4, -1, 3)
    val obstacles1 = arrayOf<IntArray>()
    assertEquals(25, walkingRobotSimulation874(commands1, obstacles1), "example 1 error")

    val commands2 = intArrayOf(4, -1, 4, -2, 4)
    val obstacles2 = arrayOf(intArrayOf(2, 4))
    assertEquals(65, walkingRobotSimulation874(commands2, obstacles2), "example 2 error")

    val commands3 = intArrayOf(6, -1, -1, 6)
    val obstacles3 = arrayOf<IntArray>()
    assertEquals(36, walkingRobotSimulation874(commands3, obstacles3), "example 3 error")

    val commands4 = intArrayOf(-2, -1, 8, 9, 6)
    val obstacles4 =
        arrayOf(
            intArrayOf(-1, 3),
            intArrayOf(0, 1),
            intArrayOf(-1, 5),
            intArrayOf(-2, -4),
            intArrayOf(5, 4),
            intArrayOf(-2, -3),
            intArrayOf(5, -1),
            intArrayOf(1, -1),
            intArrayOf(5, 5),
            intArrayOf(5, 2)
        )
    assertEquals(0, walkingRobotSimulation874(commands4, obstacles4), "example 4 error")

    val commands5 = intArrayOf(-2, -1, -2, 3, 7)
    val obstacles5 =
        arrayOf(
            intArrayOf(1, -3),
            intArrayOf(2, -3),
            intArrayOf(4, 0),
            intArrayOf(-2, 5),
            intArrayOf(-5, 2),
            intArrayOf(0, 0),
            intArrayOf(4, -4),
            intArrayOf(-2, -5),
            intArrayOf(-1, -2),
            intArrayOf(0, 2),
        )
    assertEquals(100, walkingRobotSimulation874(commands5, obstacles5), "example 5 error")
}
