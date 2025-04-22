package main.java.leetcode;

import java.util.Stack;

public class Calculate224 {

    public static int calculate(String s) {
        Stack<Integer> ops = new Stack<>();
        ops.push(1); // 用它来控制符号，正数的话 * 1 还是原来的数，负数的话就取反， *(-1) 正好就是原来数的查反数
        int sign = 1;
        int res = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                // 这里把操作符号中间的字符串都给处理了，比如: 111+1，前面的 111 就在下面的 while 循环中一次处理掉。
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                res += sign * num;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int calculate = calculate("111 - 1");
        System.out.println(calculate);
    }

}
