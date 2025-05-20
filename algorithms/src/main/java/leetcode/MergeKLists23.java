package leetcode;

import common.ListNode;

public class MergeKLists23 {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }

    public static void main(String[] args) {
        //[[1,4,5],[1,3,4],[2,6]]

        ListNode head1 = getListNode(new int[]{1, 4, 5});
        ListNode head2 = getListNode(new int[]{1, 3, 4});
        ListNode head3 = getListNode(new int[]{2, 6});


        ListNode[] listNode = {head1, head2, head3};

        mergeKLists(listNode);
    }

    private static ListNode getListNode(int[] arrays) {
        ListNode head = new ListNode();
        ListNode curNode = head;
        for (int element : arrays) {
            curNode.next = new ListNode(element);
            curNode = curNode.next;
        }
        return head;
    }

}
