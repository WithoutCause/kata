package leetcode;

import common.ListNode;

public class GetIntersectionNode160 {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointA = headA;
        ListNode pointB = headB;
        while (pointA != pointB) {
            if (pointA == null) {
                pointA = headB;
            } else {
                pointA = pointA.next;
            }
            if (pointB == null) {
                pointB = headA;
            } else {
                pointB = pointB.next;
            }

        }
        return pointA;
    }

    public static void main(String[] args) {
        ListNode commonNode1 = new ListNode(5);
        ListNode commonNode2 = new ListNode(4, commonNode1);
        ListNode commonNode3 = new ListNode(8, commonNode2);

        ListNode headA4 = new ListNode(1, commonNode3);
        ListNode headA = new ListNode(4, headA4);

        ListNode headB4 = new ListNode(1, commonNode3);
        ListNode headB5 = new ListNode(6, headB4);
        ListNode headB = new ListNode(5, headB5);

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(intersectionNode);
    }

}
