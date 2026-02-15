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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode l = new ListNode(0);
        l.next = head ;
        ListNode d = l ;
        int i = 0 ;
        ListNode s = l;
        if((head==null || head.next==null) && n>=1 ){ return null;}
        while(d!=null && i<=n ){
            d = d.next ;
            i++;
        }
        while(d!=null){
            s = s.next ;
            d = d.next ;
        }
        s.next = s.next.next ;
        return l.next;
    }
}