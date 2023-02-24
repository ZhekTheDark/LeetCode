package com.easy;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 * Example 1:
 * Input: nums = [3,1,2,4]
 * Output: [2,4,3,1]
 * Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 */
public class SortArrayByParity905 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 100% of Java online submissions for SortArray By Parity.
     * Memory Usage: 47.9 MB, less than 11.3% of Java online submissions for SortArray By Parity.
     */
    public int[] sortArrayByParity(int[] nums) {
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

        return nums;
    }
}
