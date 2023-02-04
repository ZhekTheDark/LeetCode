package com.easy;

import java.util.*;

/**
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 * <p>
 * Example 1:
 * Input: nums = [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Explanation: After squaring, the array becomes [16,1,0,9,100].
 * After sorting, it becomes [0,1,9,16,100].
 * <p>
 * Example 2:
 * Input: nums = [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * nums is sorted in non-decreasing order.
 */
public class SquaresOfASortedArray977 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 100% of Java online submissions for Squares of a Squares of a Sorted Array.
     * Memory Usage: 43.5 MB, less than 96.99% of Java online submissions for Squares of a Squares of a Sorted Array.
     */
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int lowestIndex = 0;
        int largestIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int left = nums[lowestIndex] * nums[lowestIndex];
            int right = nums[largestIndex] * nums[largestIndex];
            if (right > left) {
                result[i] = right;
                largestIndex--;
            } else {
                result[i] = left;
                lowestIndex++;
            }
        }

        return result;
    }
}
