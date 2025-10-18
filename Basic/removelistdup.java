class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class removelistdup {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // skip duplicate
            } else {
                current = current.next; // move forward
            }
        }

        return head; // ✅ Make sure this line exists
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        // Example: head = [1,1,2,3,3]
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        head = deleteDuplicates(head);
        printList(head); // Output: 1 2 3
    }
}
