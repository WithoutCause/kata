package leetcode;

import java.util.StringJoiner;

public class OddEvenList328 {

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

    public static ListNode oddEvenList(ListNode head) {
        ListNode oddNode = head;
        if (oddNode == null) {
            return null;
        }

        ListNode evenHeadNode = head.next;
        ListNode evenNode = evenHeadNode;
        if (evenNode == null) {
            return oddNode;
        }

        while (evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }

        oddNode.next = evenHeadNode;
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = oddEvenList(listNode1);

        System.out.println(listNode);
    }

}
