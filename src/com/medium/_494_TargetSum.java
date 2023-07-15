package com.medium;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 * Example 1:
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 *
 * Example 2:
 * Input: nums = [1], target = 1
 * Output: 1
 */
public class _494_TargetSum {

    int res = 0;

    /**
     * Runtime: 623ms Beats 12.70%of users with Java
     * Memory: 40.27mb Beats 82.46%of users with Java
     */
    public int findTargetSumWays(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        calculate(nums, target, 0, 0);
        return res;
    }

    private void calculate(int[] nums, int target, int sum, int i) {
        if (i == nums.length) {
            if (sum == target) {
                res++;
            }
        } else {
            calculate(nums, target, sum + nums[i], i);
            calculate(nums, target, sum - nums[i], i);
        }
    }
}
