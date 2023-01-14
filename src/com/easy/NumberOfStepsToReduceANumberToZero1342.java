package com.easy;

/**
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 * <p>
 * Example 1:
 * Input: num = 14
 * Output: 6
 * Explanation:
 * Step 1) 14 is even; divide by 2 and obtain 7.
 * Step 2) 7 is odd; subtract 1 and obtain 6.
 * Step 3) 6 is even; divide by 2 and obtain 3.
 * Step 4) 3 is odd; subtract 1 and obtain 2.
 * Step 5) 2 is even; divide by 2 and obtain 1.
 * Step 6) 1 is odd; subtract 1 and obtain 0.
 * <p>
 * Example 2:
 * Input: num = 8
 * Output: 4
 * Explanation:
 * Step 1) 8 is even; divide by 2 and obtain 4.
 * Step 2) 4 is even; divide by 2 and obtain 2.
 * Step 3) 2 is even; divide by 2 and obtain 1.
 * Step 4) 1 is odd; subtract 1 and obtain 0.
 * <p>
 * Example 3:
 * Input: num = 123
 * Output: 12
 * <p>
 * Constraints:
 * <p>
 * 0 <= num <= 10^6
 */

/**
 * Complexity Analysis:
 * Time complexity : O(log(n)).
 * Space complexity : O(1).
 *
 * Runtime: 0 ms, faster than 100% of Java online submissions for Number of Steps to Reduce a Number to Zero.
 * Memory Usage: 38.8 MB, less than 97.19% of Java online submissions for Number of Steps to Reduce a Number to Zero.
 */
public class NumberOfStepsToReduceANumberToZero1342 {

    public int numberOfSteps(int num) {
        int steps = 0;

        while (num > 0) {
            if ((num & 1) == 1) {
                num -= 1;
            } else {
                num >>= 1;
            }
            steps++;
        }

        return steps;
    }
}
