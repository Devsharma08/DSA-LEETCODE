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
    public ListNode middleNode(ListNode head) {
        ListNode single = head;
        ListNode dou = head;
        while(dou.next!= null ){
            single = single.next ; 
            dou = dou.next.next==null ? dou.next : dou.next.next ;
        }
        return single;
    }
}