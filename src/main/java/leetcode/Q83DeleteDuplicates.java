package leetcode;

import leetcode.datastructure.ListNode;

public class Q83DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
//        ListNode temp = head;
//        while (temp != null){
//            if (temp.next == null){
//                break;
//            }
//            if (temp.next.val == temp.val){
//                temp.next = temp.next.next;
//            }else {
//                temp = temp.next;
//            }
//
//        }
//        return head;
        if(null == head || null == head.next){
            return head;
        }
        ListNode now = head;
        ListNode next = head.next;
        while (next != null) {
            if (now.val == next.val) {
                next = next.next;
                if(null == next){
                    now.next = null;
                    return head;
                }
                now.next = next;
            }else {
                now = next;
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Q83DeleteDuplicates q = new Q83DeleteDuplicates();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        q.deleteDuplicates(head);
        System.out.println(head);
    }
}
