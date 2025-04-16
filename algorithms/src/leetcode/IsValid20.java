package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class IsValid20 {

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        if (charArray.length % 2 == 1) {
            return false;
        }
        HashMap<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        char c1 = s.charAt(0);
        if (pairs.keySet().contains(c1)) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (!pairs.keySet().contains(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    Character pop = stack.pop();
                    Character c2 = pairs.get(c);
                    if (!pop.equals(c2)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "(]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }

}
