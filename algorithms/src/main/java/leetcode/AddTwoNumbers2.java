package main.java.leetcode;

import java.util.StringJoiner;

public class AddTwoNumbers2 {

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

    public static ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        ListNode result = null;
        ListNode curNode = null;
        // 进位标识
        int carry = 0;
        while (list1 != null || list2 != null) {
            int num1Val = list1 != null ? list1.val : 0;
            int num2Val = list2 != null ? list2.val : 0;
            int sum = num1Val + num2Val + carry;
            carry = sum / 10;
            if (result == null) {
                result = new ListNode(sum % 10);
                curNode = result;
            } else {
                curNode.next = new ListNode(sum % 10);
                curNode = curNode.next;
            }

            if (list1 != null) {
                list1 = list1.next;
            }

            if (list2 != null) {
                list2 = list2.next;
            }
        }

        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode list1_1 = new ListNode(5);
        ListNode list1_2 = new ListNode(5, list1_1);
        ListNode list1_3 = new ListNode(5, list1_2);

        ListNode list2_1 = new ListNode(5);
        ListNode list2_2 = new ListNode(5, list2_1);
        ListNode list2_3 = new ListNode(5, list2_2);
        System.out.println(list2_3);
    }


}
