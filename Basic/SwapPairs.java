
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { 
        this.val = val; 
    }
}

public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        // Traverse the list in pairs
        while (current.next != null && current.next.next != null) {
            // Identify nodes to be swapped
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swapping pointers
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        // Return new head
        return dummy.next;
    }

    // Utility function to print list (for testing)
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Example test
    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original list:");
        printList(head);

        head = swapPairs(head);

        System.out.println("After swapping pairs:");
        printList(head);
    }
}
