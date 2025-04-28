package leetcode;

import java.util.Stack;

public class MyQueue232 {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public MyQueue232() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        /*
        ["MyQueue","push","push","push","push","pop","push","pop","pop","pop","pop"]
        [[],[1],[2],[3],[4],[],[5],[],[],[],[]]
         */
        MyQueue232 myQueue = new MyQueue232();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        int pop1 = myQueue.pop();
        myQueue.push(5);
        int pop3 = myQueue.pop();
        int pop4 = myQueue.pop();
        int pop5 = myQueue.pop();
        int pop6 = myQueue.pop();
        System.out.println(pop1 + " " + pop3 + " " + pop4 + " " + pop5 + " " + pop6);
    }
}
