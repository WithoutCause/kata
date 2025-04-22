package main.java.leetcode;

import java.util.StringJoiner;

/**
 * 这题有点傻逼。我是看官方题解。官方题解的意思是，删除最前面那个节点。
 * 如果是按照我构造的这个测试方法，那我还认。
 * 这个 deleteNode 方法是在 ListNode 对象添加的一个方法。
 */
public class DeleteNode237 {

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


        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
        
    }

    public static void main(String[] args) {

        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        
        listNode1.deleteNode(listNode4);

        System.out.println(listNode1);

    }
}
