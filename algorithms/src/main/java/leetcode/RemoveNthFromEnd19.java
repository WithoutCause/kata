package main.java.leetcode;

import java.util.StringJoiner;

/**
 * 19：删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd19 {

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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dumpNode = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dumpNode;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dumpNode.next;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode6 = removeNthFromEnd(listNode1, 2);
        System.out.println(listNode6);
        //ListNode listNode2 = new ListNode(2);
        //ListNode listNode1 = new ListNode(1, listNode2);
        //ListNode result = removeNthFromEnd(listNode1, 2);
        //System.out.println(result);
    }

}
