package main.java.leetcode;

import java.util.Stack;

public class DecodeString394 {

    public static String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> letterStack = new Stack<>();
        int num = 0;
        String letter = "";
        for (char c : chars) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                numStack.push(num);
                letterStack.push(letter);
                num = 0;
                letter = "";
            } else if (c == ']'){
                String temp = "";
                Integer pop = numStack.pop();
                for (int i = 0; i < pop; i++) {
                    temp += letter;
                }
                letter = letterStack.pop() + temp;
            } else {
                letter += c;
            }
        }
        return letter;
    }

    public static void main(String[] args) {
        String s = "100[leetcode]";
        String result = decodeString(s);
        System.out.println(result);
    }

}
