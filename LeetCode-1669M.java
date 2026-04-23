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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int i = 0 ;
        ListNode temp = list1;

        while( temp!=null && i < a-1 ){
            temp = temp.next ;
            i++;
        }

        int y = 0 ;
        ListNode temp2 = temp;

        while( temp!=null &&y < (b-a+2)){
         temp2 = temp2.next;   
         y++;
        }

        if(temp!=null) temp.next = list2;
        // temp.next = list2;
        while(temp.next!=null){
            temp = temp.next;
        }
        
        if(list2!=null)temp.next = temp2;

        return list1;
    }
}