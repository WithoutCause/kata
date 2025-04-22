package leetcode;


import common.ListNode;

public class MergeTwoLists21 {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(0);
        ListNode curNode = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curNode.next = list1;
                list1 = list1.next;
            } else {
                curNode.next = list2;
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        return dummyNode.next;
    }


    
}
