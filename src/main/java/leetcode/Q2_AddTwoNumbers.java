package leetcode;

import leetcode.datastructure.ListNode;

public class Q2_AddTwoNumbers {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next = new ListNode(4);
        Q2_AddTwoNumbers s = new Q2_AddTwoNumbers();
        ListNode listNode = s.addTwoNumbers(l1, l2);
        System.out.println(listNode);

    }
}
