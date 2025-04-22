package main.java.leetcode;

import java.util.Stack;

public class EvalRPN150 {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
                String number2 = stack.pop();
                String number1 = stack.pop();
                int calculate = calculate(number1, number2, token);
                String newToken = String.valueOf(calculate);
                stack.push(newToken);
            } else {
                stack.push(token);
            }
        }

        String pop = stack.pop();
        return Integer.parseInt(pop);
    }

    private static int calculate(String number1, String number2, String operator) {
        int n1 = Integer.parseInt(number1);
        int n2 = Integer.parseInt(number2);

        if ("+".equals(operator)) {
            return n1 + n2;
        } else if ("-".equals(operator)) {
            return n1 - n2;
        } else if ("*".equals(operator)) {
            return n1 * n2;
        } else if ("/".equals(operator)) {
            return n1 / n2;
        }
        throw new IllegalArgumentException();
    }

    public static void main(String[] args) {
        String[] tokens = {"4", "13", "5", "/", "+"};
        int i = evalRPN(tokens);
        System.out.println(i);
    }

}
