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
    public void reorderList(ListNode head) {
       // finding middle 
       ListNode fast = head , slow = head ;
       while(fast!=null && fast.next!=null){
        slow = slow.next;
        fast = fast.next.next;
       }

        ListNode secondHalf = slow.next ;
        slow.next = null ;
       ListNode prev = null , curr = secondHalf ;

       // reversing the linked list
       while(curr!=null){
        ListNode n = curr.next ;
        curr.next = prev;
        prev = curr ;
        curr = n; 
       } 
       
        ListNode l1 = head;
        ListNode l2 = prev ;
       // mergeing both lists
       while(l2!=null){
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2 ;
            l2.next = t1 ;
            l1 = t1;
            l2 = t2;
       }

    }
}