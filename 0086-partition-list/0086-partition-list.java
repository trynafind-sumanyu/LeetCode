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
    public ListNode partition(ListNode head, int x) {
        ListNode s = new ListNode();
        ListNode b = new ListNode();
        ListNode sHead = s;
        ListNode bHead = b;
        while(head != null){
            if(head.val < x){
                s.next = head;
                s = s.next;
            }
            else{
                b.next = head;
                b = b.next;
            }
            head = head.next;
        }
        s.next = bHead.next;
        b.next = null;
        return sHead.next;
    }
}