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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr = head;
        ListNode prev = head;
        
        while(curr.next != null){
            curr = curr.next;
            int gcd = gcd(prev.val, curr.val);
            ListNode newNode = new ListNode(gcd, curr);
            prev.next = newNode;
            prev = curr;
        }
        
        return head;
        
        
    }
    
    public static int gcd(int a, int b){
        if (b == 0){
            return a;
        }
        
        else 
            return gcd(b, a%b);
    }
}