/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if ( head==null||head.next == null) return false;
        ListNode single = head;
        ListNode dou = head;
        while(dou != null && dou.next!=null ){
            single = single.next ; 
            dou = dou.next.next ;
            if(single==dou) return true;

        }
        return false;
    }
}