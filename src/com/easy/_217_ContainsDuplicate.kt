package com.easy

/**
 * Given an integer array nums, return true if any value appears at least twice in the array, and return
 * false if every element is distinct.
 *
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,2,3,4]
 * Output: false
 *
 * Example 3:
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 *
 * Constraints:
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
class _217_ContainsDuplicate {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(n).
     *
     * Runtime: 467 ms, faster than 92.20% of Kotlin online submissions for Contains Duplicate.
     * Memory Usage: 50.5 MB, less than 84.40% of Kotlin online submissions for Contains Duplicate.
     */
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = nums.toSet()
        return set.size != nums.size
    }
}
