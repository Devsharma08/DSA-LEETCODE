class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node h1 = head;

        while (h1 != null) {
            Node temp = h1.next;
            h1.next = new Node(h1.val);
            h1.next.next = temp;
            h1 = temp;
        }

        h1 = head;
        while (h1 != null) {
            if (h1.random != null) {
                h1.next.random = h1.random.next;
            }
            h1 = h1.next.next;
        }

        h1 = head;
        Node f = head.next;
        Node copyHead = f;

        while (h1 != null) {
            h1.next = f.next;
            
            if (f.next != null) {
                f.next = f.next.next;
            }
            
            h1 = h1.next;
            f = f.next;
        }
        return copyHead;
    }
}