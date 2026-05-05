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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            length++;
            last = last.next;
        }

        k = k % length;
        if (k != 0) {
            last.next = head;
            int move = length-k-1;
            while (move > 0) {
                head = head.next;
                move--;
            }
            ListNode dummy = head;
            head = head.next;
            dummy.next = null;
        }
        return head;
    }

}