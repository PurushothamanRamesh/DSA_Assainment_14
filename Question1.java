class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Question1 {
    Node head;

    void detectAndRemoveLoop() {
        Node slow = head;
        Node fast = head;
        Node prev = null;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // If slow and fast meet, a loop is present
            if (slow == fast)
                break;
        }

        // If no loop is found
        if (slow != fast)
            return;

        // Move slow to the head of the list
        slow = head;

        // Find the node where the loop starts
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the loop by setting the next pointer of the last node to null
        prev.next = null;
    }

    // Function to print the linked list
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(3);
        list.head.next.next = new Node(4);
        list.head.next.next.next = list.head.next; // Creating a loop

        list.detectAndRemoveLoop();

        System.out.print("Linked List after removing the loop: ");
        list.printList();
    }
}
