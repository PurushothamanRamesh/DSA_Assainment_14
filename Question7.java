class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class LinkedList {
    int[] nextLargerNodes(ListNode head) {
        // Step 1: Count the number of nodes and store their values
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int[] values = new int[length];
        curr = head;
        for (int i = 0; i < length; i++) {
            values[i] = curr.val;
            curr = curr.next;
        }

        // Step 2: Initialize result array
        int[] result = new int[length];

        // Step 3: Initialize stack
        Stack<Integer> stack = new Stack<>();

        // Step 4: Iterate over the linked list in reverse order
        for (int i = length - 1; i >= 0; i--) {
            int currentValue = values[i];

            // Step 5: Pop stack until a node with larger value is found
            while (!stack.isEmpty() && values[stack.peek()] <= currentValue) {
                stack.pop();
            }

            // Step 6: Update result array and push current index into stack
            result[i] = stack.isEmpty() ? 0 : values[stack.peek()];
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);

        int[] result = list.nextLargerNodes(head);

        System.out.print("Output: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
