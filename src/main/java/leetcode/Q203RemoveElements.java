package leetcode;

import leetcode.datastructure.ListNode;

public class Q203RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode now = first;
        while (now.next != null) {
            if (now.next.val == val) {
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
        return first.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode temp = head.next;
        temp.next = new ListNode(3);
        temp = temp.next;
        temp.next = new ListNode(4);
        temp = temp.next;
        temp.next = new ListNode(5);

        temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            temp = temp.next;
        }
        System.out.println();

        Q203RemoveElements q = new Q203RemoveElements();
        ListNode listNode = q.removeElements(head, 5);

        while(listNode!=null){
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}
