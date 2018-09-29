package leetcode;

import leetcode.datastructure.ListNode;

public class ListReversal {
    public static void main(String[] args) {
        ListNode<Integer> listNode = new ListNode<>(1);
        listNode.next = new ListNode<>(2);
        listNode.next.next = new ListNode<>(3);
        listNode.next.next.next = new ListNode<>(4);
        ListNode<Integer> result = reverasl(listNode);
    }

    private static ListNode<Integer> reverasl(ListNode<Integer> node) {
        ListNode prev = null;
        ListNode now = node;
        while (now != null) {
            ListNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }

        return prev;
    }
}
