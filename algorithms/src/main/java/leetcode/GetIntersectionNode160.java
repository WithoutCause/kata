package main.java.leetcode;

import java.util.StringJoiner;

public class GetIntersectionNode160 {

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
