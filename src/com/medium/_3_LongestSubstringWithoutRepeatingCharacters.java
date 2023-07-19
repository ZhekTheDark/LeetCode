package com.medium;

import kotlin.test.AssertionsKt;

import java.util.HashSet;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {

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
