package com.easy;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be
 * planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n,
 * return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.
 * <p>
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * <p>
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * <p>
 * Constraints:
 * 1 <= flowerbed.length <= 2 * 10^4
 * flowerbed[i] is 0 or 1.
 * There are no two adjacent flowers in flowerbed.
 * 0 <= n <= flowerbed.length
 */
public class CanPlaceFlowers605 {

    /**
     * Complexity Analysis:
     * Time complexity : O(n).
     * Space complexity : O(1).
     * <p>
     * Runtime: 1 ms, faster than 89.19% of Java online submissions for Can Place Flowers.
     * Memory Usage: 40.3 MB, less than 91.90% of Java online submissions for Can Place Flowers.
     */
    static public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int availablePods = 0;

        for (int i = 0; i < flowerbed.length; i++) {
            if ((flowerbed.length == 1 && flowerbed[i] == 0)
                    || (i == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0)
                    || (i == (flowerbed.length - 1) && flowerbed[i] == 0 && flowerbed[i - 1] == 0)
                    || (i > 0 && i < (flowerbed.length - 1) && flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0)
            ) {
                i++;
                availablePods++;
            }
        }

        return availablePods >= n;
    }

    public static void main(String[] args) {
        int[] flowerbed = new int[5];

        flowerbed[0] = 1;
        flowerbed[1] = 0;
        flowerbed[2] = 0;
        flowerbed[3] = 0;
        flowerbed[4] = 1;
        int n = 1;

        boolean example1 = canPlaceFlowers(flowerbed, n);
        assert example1 == true;
    }
}
