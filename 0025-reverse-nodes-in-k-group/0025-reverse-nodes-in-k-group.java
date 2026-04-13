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
    public ListNode reverseKGroup(ListNode head, int k){
        int length = 0;
        ListNode dummy = head;
        while(dummy != null){
            dummy = dummy.next;
            length++;
        }
        int i = 1;
        int j = k;
        while(length >= k){
            dummy = head;
            head = reverseBetween(dummy,i,j);
            i += k;
            j += k;
            length -= k;
        }
        return head;
    }

    private ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }
        ListNode dummy = head;
        ListNode dummy2;
        int diff = right - left + 1;
        while (left > 2) {
            dummy = dummy.next;
            left--;
        }

        ListNode prev = left == 1 ? null : dummy;
        ListNode curr = prev == null ? head : dummy.next;
        dummy2 = curr;
        ListNode after = curr.next;

        while (diff > 0) {
            if (curr != null) {
                curr.next = prev;
            }
            prev = curr;
            curr = after;
            if (after != null) {
                after = after.next;
            }
            diff--;
        }
        dummy2.next = curr;
        if (left == 1) {
            head = prev;
        } else {
            dummy.next = prev;
        }
        return head;
    }
}