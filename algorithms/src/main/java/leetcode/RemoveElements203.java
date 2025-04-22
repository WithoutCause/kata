package main.java.leetcode;

import java.util.StringJoiner;

public class RemoveElements203 {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
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
    
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dumbNode = new ListNode(-1, head);
        ListNode curNode = dumbNode;
        while (curNode.next != null) {
            if (curNode.next.val == val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return dumbNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(2);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = removeElements(listNode1, 2);
        System.out.println(listNode);
    }
    
}
