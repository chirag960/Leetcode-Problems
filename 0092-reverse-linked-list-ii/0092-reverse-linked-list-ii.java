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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left == right) {
            return head;
        }
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode forward = null;
        
        ListNode joinHead = null;
        ListNode newHead = null;
        
        ListNode joinTail = null;
        ListNode newTail = null;
        
        
        int index = 1;
        while(index < right) {
            if(index < left) {
                prev = curr;
                curr = curr.next;
            }
            else if(index == left) {
                joinHead = prev;
                newTail = curr;
                prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            else if(index > left){
                forward = curr.next;
                curr.next = prev;
                prev = curr;
                curr = forward;
            }
            index++;
        }
        
        if(index == right && right != 1){
            forward = curr.next;
            
            joinTail = forward;
            newHead = curr;
            if(left == 1){
                head = newHead;
            }
            
            curr.next = prev;
            
            if(joinHead != null){
                joinHead.next = newHead;    
            }
            
            newTail.next = joinTail;
        }
        return head;
    }
}