package leetcode;


public class MyCircularDeque641 {


    /**
     * 设计实现双端队列。
     *
     * 实现 MyCircularDeque 类:
     *
     * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
     * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
     * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
     * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
     * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
     * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
     * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
     * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
     * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
     */

    private int size;
    private int count;
    private Node first;
    private Node last;


    public MyCircularDeque641(int k) {
        this.count = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        Node f = first;
        Node newNode = new Node(null, value, f);
        first = newNode;
        if (f == null) {
            last = newNode;
        } else {
            f.prev = newNode;
        }
        size++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        Node l = last;
        Node newNode = new Node(l, value, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (first == null) {
            return false;
        }
        first = first.next;
        if (first != null) {
            first.prev = null;
        } else {
            // 删除的是最后一个元素，同时要把 last 置空
            last = null;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (last == null) {
            return false;
        }
        last = last.prev;
        if (last != null) {
            last.next = null;
        } else {
            // 删除的是最后一个元素，同时要把 first 置空
            first = null;
        }
        size--;
        return true;
    }

    public int getFront() {
        if (first == null) {
            return -1;
        }
        return first.value;
    }

    public int getRear() {
        if (last == null) {
            return -1;
        }
        return last.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size >= count;
    }

    private static class Node {
        int value;
        Node prev;
        Node next;

        public Node(Node prev, int value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Your MyCircularDeque object will be instantiated and called as such:
     * MyCircularDeque obj = new MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */
    public static void main(String[] args) {
        // ["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
        // [[3],[1],[2],[3],[4],[],[],[],[4],[]]
        MyCircularDeque641 myCircularDeque641 = new MyCircularDeque641(3);
        boolean b = myCircularDeque641.insertLast(1);

    }

}
