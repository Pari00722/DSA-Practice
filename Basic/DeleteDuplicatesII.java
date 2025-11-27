public class DeleteDuplicatesII {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        // Dummy node simplifies edge cases (like deleting the first nodes).
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy; // prev.next is the start of the candidate unique segment
        ListNode cur = head;

        while (cur != null) {
            // If this node has a duplicate (next exists and same value)
            if (cur.next != null && cur.val == cur.next.val) {
                int dupVal = cur.val;
                // Skip all nodes with value dupVal
                while (cur != null && cur.val == dupVal) {
                    cur = cur.next;
                }
                // Link prev to the node after the duplicates
                prev.next = cur;
            } else {
                // No duplicate for cur, move prev forward
                prev = cur;
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    // Helper: build linked list from array
    public static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Helper: convert list to string for printing
    public static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        while (head != null) {
            if (!first) sb.append(",");
            sb.append(head.val);
            first = false;
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        // Example 1
        ListNode h1 = build(new int[]{1,2,3,3,4,4,5});
        ListNode r1 = deleteDuplicates(h1);
        System.out.println(listToString(r1)); // expected [1,2,5]

        // Example 2
        ListNode h2 = build(new int[]{1,1,1,2,3});
        ListNode r2 = deleteDuplicates(h2);
        System.out.println(listToString(r2)); // expected [2,3]

        // Edge cases
        ListNode h3 = build(new int[]{});      // empty
        System.out.println(listToString(deleteDuplicates(h3))); // []

        ListNode h4 = build(new int[]{1,1,2,2}); // all duplicates
        System.out.println(listToString(deleteDuplicates(h4))); // []
    }
}
