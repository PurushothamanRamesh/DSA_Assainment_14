class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class LinkedList {
    ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        Stack<ListNode> stack = new Stack<>();
        int runningSum = 0;

        while (current != null) {
            runningSum += current.val;

            if (runningSum == 0) {
                while (!stack.isEmpty()) {
                    stack.pop();
                }
                dummy.next = current.next;
            } else if (stack.contains(current)) {
                ListNode prev = stack.pop();
                prev.next = current.next;
            } else {
                stack.push(current);
            }

            current = current.next;
        }

        return dummy.next;
    }

    void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(-3);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(1);

        System.out.println("Input: ");
        list.printList(head1);

        ListNode result1 = list.removeZeroSumSublists(head1);
        System.out.println("Output: ");
        list.printList(result1);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(-3);
        head2.next.next.next.next = new ListNode(4);

        System.out.println("Input: ");
        list.printList(head2);

        ListNode result2 = list.removeZeroSumSublists(head2);
        System.out.println("Output: ");
        list.printList(result2);

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);
        head3.next.next = new ListNode(3);
        head3.next.next.next = new ListNode(-3);
        head3.next.next.next.next = new ListNode(-2);

        System.out.println("Input: ");
        list.printList(head3);

        ListNode result3 = list.removeZeroSumSublists(head3);
        System.out.println("Output: ");
        list.printList(result3);
    }
}
