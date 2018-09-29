package leetcode;

import leetcode.datastructure.ListNode;

public class AddTwoNumbers_Q2 {

        public ListNode addTwoNumbers(ListNode<Integer> l1, ListNode<Integer> l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            ListNode curr = new ListNode(0);
            int carry = 0;
            ListNode result = curr;
            while (l1 != null || l2 != null) {
                int sum = carry + (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val);
                carry = sum / 10;
                curr.next = new ListNode(sum % 10);
                curr = curr.next;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            return result.next;
        }

    public static void main(String[] args) {
        ListNode<Integer> l1 = new ListNode<>(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        ListNode<Integer> l2 = new ListNode<>(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        AddTwoNumbers_Q2 s = new AddTwoNumbers_Q2();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }
}
