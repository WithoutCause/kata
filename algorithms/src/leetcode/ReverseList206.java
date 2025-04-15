package leetcode;

import java.util.StringJoiner;

public class ReverseList206 {

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

    public static ListNode reverseList(ListNode head) {
        ListNode prevNode = null; // 记录上一个节点的位置
        ListNode curNode = head; // 一直移动的指针，用它来遍历链表
        while (curNode != null) {
            ListNode nextNode = curNode.next; //先记录当前节点的 next 节点
            curNode.next = prevNode; //把当前节点的 next 节点设置成上一个节点的值，这里开始反转
            prevNode = curNode; //移动节点
            curNode = nextNode;
        }

        return prevNode;
    }

    public static void main(String[] args) {

    }

}
