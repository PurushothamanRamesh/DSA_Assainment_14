class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

public class Question3 {
    Node head;

    // Function to merge two sorted lists
    Node merge(Node a, Node b) {
        if (a == null)
            return b;
        if (b == null)
            return a;

        Node result;
        if (a.data <= b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        result.next = null;
        return result;
    }

    // Function to flatten the linked list
    Node flatten(Node root) {
        // Base case: if the root or root.next is null, return the root
        if (root == null || root.next == null)
            return root;

        // Recursively flatten the rest of the list
        root.next = flatten(root.next);

        // Merge the current list with the flattened list
        root = merge(root, root.next);

        // Return the flattened list
        return root;
    }

    // Function to print the flattened linked list
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }

    // Driver code
    public static void main(String[] args) {
        Question3 list = new Question3();
        list.head = new Node(5);
        list.head.next = new Node(10);
        list.head.next.next = new Node(19);
        list.head.next.next.next = new Node(28);

        list.head.bottom = new Node(7);
        list.head.bottom.bottom = new Node(8);
        list.head.bottom.bottom.bottom = new Node(30);

        list.head.next.bottom = new Node(20);

        list.head.next.next.bottom = new Node(22);
        list.head.next.next.next.bottom = new Node(35);

        list.head.next.next.bottom.bottom = new Node(50);

        list.head.next.next.next.bottom = new Node(40);
        list.head.next.next.next.bottom.bottom = new Node(45);

        Node flattenedList = list.flatten(list.head);

        System.out.println("Flattened Linked List:");
        list.printList(flattenedList);
    }
}
