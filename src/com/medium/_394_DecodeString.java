package com.medium;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 * <p>
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * <p>
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed,
 * etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there will not be input like 3a or 2[4].
 * <p>
 * The test cases are generated so that the length of the output will never exceed 105.
 * <p>
 * Example 1:
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * <p>
 * Example 2:
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * <p>
 * Example 3:
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * <p>
 * Constraints:
 * 1 <= s.length <= 30
 * s consists of lowercase English letters, digits, and square brackets '[]'.
 * s is guaranteed to be a valid input.
 * All the integers in s are in the range [1, 300].
 */
public class _394_DecodeString {

    /**
     * Runtime: 1ms Beats 77.28% of users with Java
     * Memory: 40.42mb Beats 84.15% of users with Java
     */
    public static String decodeStringStack(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> repeatStack = new Stack<>();
        int index = 0;
        StringBuilder res = new StringBuilder();

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int i = index;
                while (Character.isDigit(s.charAt(i))) {
                    i++;
                }
                repeatStack.push(Integer.parseInt(s.substring(index, i)));
                index = i;
            } else if (s.charAt(index) == '[') {
                stringStack.push(res.toString());
                res = new StringBuilder();
                index++;
            } else if (s.charAt(index) == ']') {
                String str = stringStack.pop();
                int repeat = repeatStack.pop();
                StringBuilder temp = new StringBuilder(str);
                for (int i = 0; i < repeat; i++) {
                    temp.append(res);
                }
                res = new StringBuilder(temp.toString());
                index++;
            } else {
                res.append(s.charAt(index));
                index++;
            }
        }

        return res.toString();
    }

    /**
     * Runtime: 0-ms Beats 100.00% of users with Java
     * Memory: 40.66mb Beats 58.57% of users with Java
     */
    int i = 0;
    public String decodeStringRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String tmp_string = "";

        while (i < s.length()) {
            char c = s.charAt(i);
            i++;

            if (c == '[') {
                tmp_string = decodeStringRecursive(s);
                for (int j = 0; j < count; j++) {
                    sb.append(tmp_string);
                }
                count = 0;
            } else if (c == ']') {
                break;
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(decodeStringStack("3[a]2[bc]"));  //aaabcbc
        System.out.println(decodeStringStack("3[a2[c]]"));  //accaccacc
        System.out.println(decodeStringStack("2[abc]3[cd]ef"));  //abcabccdcdcdef
    }
}
