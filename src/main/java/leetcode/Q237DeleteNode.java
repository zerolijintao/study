package leetcode;

import leetcode.datastructure.ListNode;

public class Q237DeleteNode {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
    }
}
