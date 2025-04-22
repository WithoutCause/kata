package leetcode;

import common.ListNode;


public class RemoveElements203 {

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
