class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }

        Stack<ListNode> st = new Stack<>();
        ListNode curr = pre.next;
        for (int i = 0; i <= (right - left); i++) {
            st.push(curr);
            curr = curr.next;
        }

        ListNode post = curr;

        while (!st.isEmpty()) {
            pre.next = st.pop();
            pre = pre.next;
        }

        pre.next = post;

        return dummy.next;
    }
}