package leetcode;

import common.ListNode;


public class DeleteDuplicates82 {

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode curNode = dummyNode;
        while (curNode.next != null && curNode.next.next != null) {
            int val = curNode.next.val;
            if (val == curNode.next.next.val) {
                while (curNode.next != null && curNode.next.val == val) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 3, 4, 5};
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
