package main.java.leetcode;

import java.util.StringJoiner;

/**
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 */
public class SwapPairs24 {

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

    private static ListNode swapPairs(ListNode head) {
        // 添加一个哑节点
        ListNode dumbNode = new ListNode(0, head);
        ListNode temp = dumbNode;
        while (temp.next != null && temp.next.next != null) {
            // node1 和 node2 节点相差 1
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;

            // 交换 node1 和 node2,temp 节点指向新的节点，因为这个时候 node1 和 node2 交换了，所以 node2 的位置应该在 node1 前面了
            // 例如: 0 -> 1 -> 2 -> 3 -> 4 交换后就是 0 -> 2 -> 1 -> 3 -> 4 这时候如果 temp 应该指向 2 而不是 1.
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }

        return dumbNode.next;
    }


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = swapPairs(listNode1);
        System.out.println(listNode);
    }

}
