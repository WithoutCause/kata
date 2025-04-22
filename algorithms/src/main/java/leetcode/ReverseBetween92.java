package leetcode;

import common.ListNode;

public class ReverseBetween92 {

    /**
     * 思路：使用头插头。先遍历 left，将 left 定义到 left - 1 的位置。(left - 1).next 就是要翻转的第一个节点
     * 再遍历 (right - left) ，这一段就是要挨个翻转的长度
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(0, head);
        ListNode prevNode = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            prevNode = prevNode.next;
        }
        // 循环到这里执行完，prevNode 就在要翻转的节点的前一个节点了

        ListNode curNode = prevNode.next;
        ListNode nextNode;
        for (int i = 0; i < right - left; i++) {
            nextNode = curNode.next;

            curNode.next = nextNode.next;
            nextNode.next = prevNode.next;
            prevNode.next = nextNode;
        }

        return dummyNode.next;
    }
    


    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);

        ListNode listNode = reverseBetween(listNode1, 1, 5);
        System.out.println(listNode);
    }

}
