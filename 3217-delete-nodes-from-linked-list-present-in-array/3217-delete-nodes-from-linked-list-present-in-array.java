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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode currrent = head;

        while (head != null && set.contains(head.val)) {
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode dummy = head;

        while(dummy.next != null){
            if(set.contains(dummy.next.val)){
                dummy.next = dummy.next.next;
            }
            else {
                dummy = dummy.next;
            }
        }
        return head;
    }

}