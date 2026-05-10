/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        // find the middle of the list and split it
        ListNode middle = findMid(head);
        ListNode second = middle.next;
        middle.next = null;
        // reverse 2nd list
        ListNode s2 = reverse(second);
        // combine them
        ListNode s1 = head;
        while (s2 != null) {
            ListNode tmp1 = s1.next;
            ListNode tmp2 = s2.next;
            s1.next = s2;
            s2.next = tmp1;
            s1 = tmp1;
            s2 = tmp2;
        }

    }
    private ListNode findMid(ListNode head) {
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}
