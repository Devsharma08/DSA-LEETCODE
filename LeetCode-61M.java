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
        if(head==null || head.next==null || k==0 ) return head; 
        ListNode temp = head;
        ListNode ans = head;

        int size = 1 ;
        while(temp!=null && temp.next!=null){
            size++;
            temp = temp.next ;
        }

        if(k==size) return head;
        k = (size <= k) ? k % size : k ;  
        if(k==0) return head;
        int rem = size - k ;
        ListNode t1 = head;  

        for(int i = 0 ; rem > i ; i++){
            t1 = t1.next;
        }

        ListNode f = t1;
        ListNode fa = f;

        for(int i = 0 ; k-1 > i ; i++){
            f = f.next;
        }
        
        if(f!=null){
            f.next = ans;
        }
        for(int i = 0 ; ( t1!=null && t1.next!=null && rem > i ) ; i++){
            f = f.next;
        }
        if(f!=null){
            f.next = null;
        }
        return fa;
    }
}