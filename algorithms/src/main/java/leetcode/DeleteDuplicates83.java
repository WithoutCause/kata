package leetcode;

import java.util.StringJoiner;


public class DeleteDuplicates83 {

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(){}

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

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode curNode = head;
        while (curNode.next != null) {
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        int[] arrays = {};
        ListNode head = new ListNode();
        ListNode curNode = head;
        for (int element : arrays) {
            curNode.next = new ListNode(element);
            curNode = curNode.next;
        }
        ListNode listNode = deleteDuplicates(head.next);
        System.out.println(listNode);
    }
    
}
