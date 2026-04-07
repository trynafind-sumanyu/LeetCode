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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode curr = head;
        ListNode prev;
        ListNode after = head.next;
        ListNode dummy = after;

        while(curr != null && curr.next != null){

            curr.next = after.next;
            after.next = curr;
            prev = curr;
            curr = curr.next;
            if(curr != null && curr.next!=null){
                after = curr.next;
            }
            else{
                after = curr;
            }
            prev.next = after;
        }
        return dummy;
    }
}