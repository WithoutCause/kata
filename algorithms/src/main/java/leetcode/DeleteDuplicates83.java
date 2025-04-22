package leetcode;

import common.ListNode;

public class DeleteDuplicates83 {

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
