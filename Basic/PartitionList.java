public class PartitionList {
    

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int v) { val = v; }
    }

    public static ListNode partition(ListNode head, int x) {
        // Two dummy heads for "before" and "after" lists
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead  = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after  = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        // Important: terminate the 'after' list to avoid possible cycle
        after.next = null;
        // Join before list with after list
        before.next = afterHead.next;

        return beforeHead.next;
    }

    // helper to build list from array
    public static ListNode build(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int v : arr) {
            cur.next = new ListNode(v);
            cur = cur.next;
        }
        return dummy.next;
    }

    // helper to print list
    public static void printList(ListNode head) {
        System.out.print("[");
        boolean first = true;
        while (head != null) {
            if (!first) System.out.print(",");
            System.out.print(head.val);
            first = false;
            head = head.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Example 1
        ListNode h1 = build(new int[]{1,4,3,2,5,2});
        ListNode ans1 = partition(h1, 3);
        printList(ans1); // expected [1,2,2,4,3,5]

        // Example 2
        ListNode h2 = build(new int[]{2,1});
        ListNode ans2 = partition(h2, 2);
        printList(ans2); // expected [1,2]
    }
}
