package com.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return
 * the next greater number for every element in nums.
 * <p>
 * The next greater number of a number x is the first greater number to its traversing-order next in the array, which
 * means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 * <p>
 * Example 1:
 * Input: nums = [1,2,1]
 * Output: [2,-1,2]
 * Explanation: The first 1's next greater number is 2;
 * The number 2 can't find next greater number.
 * The second 1's next greater number needs to search circularly, which is also 2.
 * <p>
 * Example 2:
 * Input: nums = [1,2,3,4,3]
 * Output: [2,3,4,-1,4]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class _503_NextGreaterElementII {

    private static class Pair {

        Integer first;
        Integer second;

        public Pair(Integer first, Integer second) {
            this.first = first;
            this.second = second;
        }
    }

    /**
     * Complexity Analysis:
     * Time complexity : O(1).
     * Space complexity : O(n).
     * <p>
     * Runtime: 36 ms, faster than 58.5% of Java online submissions for Next Greater Element II.
     * Memory Usage: 44 MB, less than 83.22% of Java online submissions for Next Greater Element II.
     */
    public static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[2 * n];
        Arrays.fill(res, -1);
        Stack<Pair> stack = new Stack<>();

        int[] arr = new int[n * 2 - 1];
        System.arraycopy(nums, 0, arr, 0, n);
        System.arraycopy(nums, 0, arr, n, n - 1);

        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek().second < arr[i]) {
                Pair pop = stack.pop();
                res[pop.first] = arr[i];
            }
            stack.push(new Pair(i, arr[i]));
        }

        res = Arrays.copyOf(res, n);
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        nextGreaterElements(nums);
    }
}
