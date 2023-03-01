package com.easy;

import javafx.util.Pair;

/**
 * Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
 *
 * Example 1:
 * Input: nums = [3,2,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2.
 * The third distinct maximum is 1.
 *
 * Example 2:
 * Input: nums = [1,2]
 * Output: 2
 * Explanation:
 * The first distinct maximum is 2.
 * The second distinct maximum is 1.
 * The third distinct maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: nums = [2,2,3,1]
 * Output: 1
 * Explanation:
 * The first distinct maximum is 3.
 * The second distinct maximum is 2 (both 2's are counted together since they have the same value).
 * The third distinct maximum is 1.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 *
 * Follow up: Can you find an O(n) solution?
 */
public class ThirdMaximumNumber414 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 9 ms, faster than 15.60% of Java online submissions for Third Maximum Number.
     * Memory Usage: 41.9 MB, less than 84.18% of Java online submissions for Third Maximum Number.
     */
    public int thirdMax(int[] nums) {
        Pair<Integer, Boolean> firstMax = new Pair<>(-1, false);
        Pair<Integer, Boolean> secondMax = new Pair<>(-1, false);
        Pair<Integer, Boolean> thirdMax = new Pair<>(-1, false);

        for (int num : nums) {
            if ((firstMax.getValue() && firstMax.getKey() == num) ||
                    (secondMax.getValue() && secondMax.getKey() == num) ||
                    (thirdMax.getValue() && thirdMax.getKey() == num)) {
                continue;
            }

            if (!firstMax.getValue() || firstMax.getKey() <= num) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = new Pair<>(num, true);
            } else if (!secondMax.getValue() || secondMax.getKey() <= num) {
                thirdMax = secondMax;
                secondMax = new Pair<>(num, true);
            } else if (!thirdMax.getValue() || thirdMax.getKey() <= num) {
                thirdMax = new Pair<>(num, true);
            }
        }

        if (!thirdMax.getValue()) {
            return firstMax.getKey();
        }

        return thirdMax.getKey();
    }
}
