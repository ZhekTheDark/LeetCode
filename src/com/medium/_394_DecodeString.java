package com.medium;

import java.util.Stack;

public class _394_DecodeString {

//    public static String decodeString(String s) {
//        StringBuilder res = new StringBuilder();
//
//        Stack<String> stack = new Stack<>();
//        int i = 0;
//        while (Character.isLetter(s.charAt(i))) {
//            res.append(s.charAt(i++));
//        }
//        while (i < s.length()) {
//            int j = i + 1;
//            while (s.charAt(j) != '[' || Character.isDigit(s.charAt(j))) {
//                j++;
//            }
//            stack.push(s.substring(i, j));
//            j++;
//            i = j;
//
//            while (Character.isLetter(s.charAt(j))) {
//                j ++;
//            }
//            StringBuilder textToProcess = new StringBuilder();
//            String textToRepeat = s.substring(i, j);
//            if (s.charAt(j) == ']') {
//                int repeat = Integer.parseInt(stack.pop());
//                for (int z = 0; z < repeat; z++) {
//                    textToProcess.append(textToRepeat);
//                }
//                stack.push(textToProcess.toString());
//            } else  {
//                stack.push(textToRepeat);
//            }
//            j++;
//            i = j;
//        }
//
//        while (!stack.isEmpty()) {
//            res.insert(0, stack.pop());
//        }
//
//        return res.toString();
//    }

    public static void main(String[] args) {
//        System.out.println(decodeString("3[a]2[bc]")); //aaabcbc
        System.out.println(decodeString("3[a2[c]]"));
    }
}
