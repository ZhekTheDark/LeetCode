package com.medium;

public class _443_StringCompression {

    static public int compress1(char[] chars) {
        if (chars.length < 2) {
            return chars.length;
        }
        StringBuilder res = new StringBuilder();
        int i= 0;
        while (i < chars.length) {
            char c = chars[i];
            res.append(c);
            int j = i;
            while (j < chars.length && chars[j] == c) {
                j++;
            }
            if (j - i > 0) {
                res.append(j - i);
            }
            i = j;
        }
        chars = res.toString().toCharArray();
        return res.toString().length();
    }

    /**
     * Runtime: 1ms Beats 96.66% of users with Java
     * Memory: 43.26mb Beats 58.27% of users with Java
     */
    static public int compress2(char[] chars) {
        int n = chars.length;
        int i = 0, j = 0;
        while (i < n) {
            int count = 1;
            while (i + 1 < n && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            chars[j++] = chars[i];
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int k = 0; k < countStr.length(); k++) {
                    chars[j] = countStr.charAt(k);
                    j++;
                }
            }
            i++;
        }
        return j;
    }

    public static void main(String[] args) {
        char[] chars1 = {'a','a','b','b','c','c','c'};
        compress2(chars1);
    }
}
