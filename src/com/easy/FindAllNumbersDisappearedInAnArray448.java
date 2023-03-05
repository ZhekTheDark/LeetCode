package com.easy;

import java.util.ArrayList;
import java.util.List;

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
