class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Question2 {
    Node head;

    // Function to add 1 to the number represented as a linked list
    Node addOne(Node head) {
        Node curr = head;
        Node lastNotNine = null;

        // Traverse the linked list from right to left
        while (curr != null) {
            if (curr.data < 9) {
                lastNotNine = curr;
            }
            curr = curr.next;
        }

        // If a digit less than 9 is found, increment it by 1 and break the loop
        if (lastNotNine != null) {
            lastNotNine.data++;
        }
        // If all digits are 9, change all the 9s to 0s and insert a new node with value 1 at the beginning
        else {
            lastNotNine = new Node(0);
            lastNotNine.next = head;
            head = lastNotNine;
            lastNotNine.data = 1;
        }

        // Change all the following nodes to 0
        curr = lastNotNine.next;
        while (curr != null) {
            curr.data = 0;
            curr = curr.next;
        }

        return head;
    }

    // Function to print the linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.next;
        }
        System.out.println("null");
    }

    // Driver code
    public static void main(String[] args) {
        Question2 list = new Question2();
        list.head = new Node(4);
        list.head.next = new Node(5);
        list.head.next.next = new Node(6);

        System.out.print("Original Linked List: ");
        list.printList(list.head);

        list.head = list.addOne(list.head);

        System.out.print("Modified Linked List after adding 1: ");
        list.printList(list.head);
    }
}
