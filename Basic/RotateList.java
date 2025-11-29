public class RotateList {
    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Rotates the list to the right by k places.
    public static ListNode rotateRight(ListNode head, long k) {
        if (head == null || head.next == null) return head;

        // compute length and tail
        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        int r = (int)(k % n);
        if (r == 0) return head;

        // make it a cycle
        tail.next = head;

        // find new tail: node at position n - r (1-indexed)
        int stepsToNewTail = n - r;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; // break cycle
        return newHead;
    }

    // Helper: build list from array
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    // Helper: print list
    public static void printList(ListNode head) {
        System.out.print("[");
        ListNode cur = head;
        boolean first = true;
        while (cur != null) {
            if (!first) System.out.print(",");
            System.out.print(cur.val);
            first = false;
            cur = cur.next;
        }
        System.out.println("]");
    }

    // Main: run provided examples
    public static void main(String[] args) {
        int[] ex1 = {1,2,3,4,5};
        ListNode head1 = buildList(ex1);
        ListNode res1 = rotateRight(head1, 2);
        System.out.print("Example 1 output: ");
        printList(res1); // expected [4,5,1,2,3]

        int[] ex2 = {0,1,2};
        ListNode head2 = buildList(ex2);
        ListNode res2 = rotateRight(head2, 4);
        System.out.print("Example 2 output: ");
        printList(res2); // expected [2,0,1]
    }
}
