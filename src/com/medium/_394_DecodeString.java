package com.medium;

import java.util.Stack;

public class _394_DecodeString {

    public static String decodeString(String s) {
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

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));  //aaabcbc
        System.out.println(decodeString("3[a2[c]]"));  //accaccacc
    }
}
