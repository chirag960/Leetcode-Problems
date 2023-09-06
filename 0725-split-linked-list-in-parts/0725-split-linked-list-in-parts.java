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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        
        ListNode curr = head;
        while(curr!= null){
            curr = curr.next;
            size++;
        }
        
        int listSize = size/k;
        int extra = size%k;
        
        ListNode[] answer = new ListNode[k];
        
        curr = head;
        for(int i=0;i<k;i++){
            ListNode root = curr;
            for(int j=0;j<listSize + (i < extra ? 1 : 0) - 1; j++) {
                if(curr != null) {
                    curr = curr.next;
                }
            }
            if(curr != null) {
                ListNode prev = curr;
                curr = curr.next;
                prev.next = null;
            }
            answer[i] = root;
        }
        return answer;
    }
}