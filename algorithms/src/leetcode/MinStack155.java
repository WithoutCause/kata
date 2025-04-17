package leetcode;

import java.util.LinkedList;

/**
 * 这一题，官方题解不讲武德，居然用的 LinkedList ，我以为要自己实现栈的结构呢。
 */
public class MinStack155 {

    private final LinkedList<Integer> stack;
    private final LinkedList<Integer> minStack;

    public MinStack155() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(), val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack155 minStack = new MinStack155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();//--> 返回 -3.
        System.out.println(min);

        minStack.pop();
        int top = minStack.top();//--> 返回 0.
        System.out.println(top);

        int min1 = minStack.getMin();//--> 返回 -2.
        System.out.println(min1);


    }

}
