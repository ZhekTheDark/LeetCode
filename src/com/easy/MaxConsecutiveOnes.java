package com.easy;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * <p>
 * Example 1:
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s. The maximum number of consecutive 1s is 3.
 * <p>
 * Example 2:
 * Input: nums = [1,0,1,1,0,1]
 * Output: 2
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^5
 * nums[i] is either 0 or 1.
 */
public class MaxConsecutiveOnes {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 2 ms, faster than 78.05% of Java online submissions for Max Consecutive Ones.
     * Memory Usage: 42.7 MB, less than 99.20% of Java online submissions for Max Consecutive Ones.
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int current = 0;

        for (int i : nums) {
            if (i == 1) {
                current++;
            } else {
                current = 0;
            }
            if (current > max) {
                max = current;
            }
        }

        return max;
    }
}
