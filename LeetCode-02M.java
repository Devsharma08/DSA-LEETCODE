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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode aa = new ListNode(0); 
    ListNode sum = aa;             
    int carry = 0; 
    
    while(l1 != null || l2 != null || carry != 0) {
        int v1 = (l1 == null) ? 0 : l1.val;
        int v2 = (l2 == null) ? 0 : l2.val;
        
        int s = v1 + v2 + carry;
        carry = s / 10;
        sum.next = new ListNode(s % 10);
       
        sum = sum.next; 
        if (l1 != null) l1 = l1.next;   
        if (l2 != null) l2 = l2.next;
    }
    
    return aa.next;
    }
}