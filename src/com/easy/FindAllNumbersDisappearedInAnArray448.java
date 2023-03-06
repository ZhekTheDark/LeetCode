package com.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 * <p>
 * Example 1:
 * Input: nums = [4,3,2,7,8,2,3,1]
 * Output: [5,6]
 * <p>
 * Example 2:
 * Input: nums = [1,1]
 * Output: [2]
 * <p>
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 * <p>
 * Follow up: Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindAllNumbersDisappearedInAnArray448 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 6 ms, faster than 69.96% of Java online submissions for Move Zeroes.
     * Memory Usage: 50.6 MB, less than 62.46% of Java online submissions for Move Zeroes.
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int n : nums) {
            int index = Math.abs(n);
            if (nums[index - 1] > 0) {
                nums[index - 1] *= -1;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}
