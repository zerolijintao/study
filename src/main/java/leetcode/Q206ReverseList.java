package leetcode;

import leetcode.datastructure.ListNode;

public class Q206ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p3 = head.next.next;
        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        head.next = null;
        head = p1;
        return head;
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

        //逆序前输出链表
        temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }

        //逆序链表
        Q206ReverseList q = new Q206ReverseList();
        ListNode listNode = q.reverseList(head);

        //逆序后输出链表
        while(listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
