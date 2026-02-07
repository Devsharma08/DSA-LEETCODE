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
    public ListNode sortList(ListNode head) {

        if( head == null || head.next == null ){
            return head;
        }

        ListNode mid = findMid(head);
        ListNode leftSide = head;
        ListNode rightSide = mid.next ;
        mid.next = null ;

        ListNode left = sortList(leftSide);
        ListNode right = sortList(rightSide);

        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0) ;
        ListNode current = dummy ;

        while(left != null && right != null){
            if(left.val < right.val){
                current.next = left ;
                left = left.next ;
            } else {
                current.next = right ;
                right = right.next ;
            }
            current = current.next ;
        }

        current.next = (left != null) ? left : right ;
        return dummy.next; 

    }

    private ListNode findMid(ListNode head){
        ListNode single = head ;
        ListNode twice = head ;

        while(twice.next != null && twice.next.next != null){

            twice = twice.next.next ;
            single = single.next ;

        }
        return single ;
    }
}