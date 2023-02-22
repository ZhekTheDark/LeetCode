package com.easy;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 * <p>
 * Example 1:
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * <p>
 * Example 2:
 * Input: nums = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * <p>
 * Follow up: Could you minimize the total number of operations done?
 */
public class MoveZeroes283 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 100% of Java online submissions for Move Zeroes.
     * Memory Usage: 43.5 MB, less than 77.85% of Java online submissions for Move Zeroes.
     */
    public void moveZeroes(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length - 1;
        int nonZeroIndex = nums.length - 1;

        while (i >= 0) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[nonZeroIndex] = temp;
                nonZeroIndex--;
            }
            i--;
        }

        i++;
        nonZeroIndex++;
        while (nonZeroIndex < nums.length) {
            int temp = nums[i];
            nums[i] = nums[nonZeroIndex];
            nums[nonZeroIndex] = temp;
            i++;
            nonZeroIndex++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        new MoveZeroes283().moveZeroes(arr);
    }
}
