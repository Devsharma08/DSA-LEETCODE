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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode l1:lists){
            while(l1!=null){
                pq.add(l1.val);
                l1 = l1.next;
            }
        }
        ListNode h1 = new ListNode(0);
        ListNode dummy = h1;
        while(!pq.isEmpty()){
            dummy.next = new ListNode(pq.poll());
            dummy = dummy.next;
        }
        return h1.next;
    }
}