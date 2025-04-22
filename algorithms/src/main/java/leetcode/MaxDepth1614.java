package main.java.leetcode;

public class MaxDepth1614 {

    public static int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int size = 0;
        int maxSize = 0;
        for (char c : chars) {
            if (c == '(') {
                size++;
                maxSize = Math.max(size, maxSize);
            } else if (c == ')') {
                size--;
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        String s = "()(())((()()))";
        int i = maxDepth(s);
        System.out.println(i);
    }
}
