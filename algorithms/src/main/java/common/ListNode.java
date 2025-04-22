package common;

import java.util.StringJoiner;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(){}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner("->");
        ListNode current = this;
        while (current != null) {
            sj.add(current.val + "");
            current = current.next;
        }
        return sj.toString();
    }
}
