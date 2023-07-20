package com.medium;

import kotlin.test.AssertionsKt;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Constraints:
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {

    /**
     * Runtime: 8ms Beats 60.84% of users with Java
     * Memory: 43.91mb Beats 36.66% of users with Java
     */
    public static int lengthOfLongestSubstring(String s) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int l = 0;
        while (i < s.length()) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i++));
                res = Math.max(res, set.size());
            } else {
                set.remove(s.charAt(l++));
            }
        }
        res = Math.max(res, set.size());
        return res;
    }

    public static void main(String[] args) {
        int res1 = lengthOfLongestSubstring("aabaab!bb");
        AssertionsKt.assertEquals(3, res1, "1");
        int res2 = lengthOfLongestSubstring("bpfbhmipx");
        AssertionsKt.assertEquals(7, res2, "2");
        int res3 = lengthOfLongestSubstring("umvejcuuk");
        AssertionsKt.assertEquals(6, res3, "3");
        int res4 = lengthOfLongestSubstring("loddktdji");
        AssertionsKt.assertEquals(5, res4, "4");
        System.out.println("GG WP!");
    }
}
