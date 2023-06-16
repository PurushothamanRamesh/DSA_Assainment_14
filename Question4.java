class Node {
    int data;
    Node next, random;

    Node(int data) {
        this.data = data;
        next = random = null;
    }
}

public class Question4 {
    Node head;

    void printList(Node node) {
        while (node != null) {
            int randomData = (node.random != null) ? node.random.data : -1;
            System.out.println("Data: " + node.data + ", Random Data: " + randomData);
            node = node.next;
        }
    }

    Node cloneLinkedList(Node head) {
        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = new Node(head.data);
        map.put(head, newHead);

        Node curr = head;
        Node newCurr = newHead;

        while (curr.next != null) {
            newCurr.next = new Node(curr.next.data);
            map.put(curr.next, newCurr.next);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        curr = head;
        newCurr = newHead;

        while (curr != null) {
            newCurr.random = map.get(curr.random);
            curr = curr.next;
            newCurr = newCurr.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Question4 list = new Question4();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);

        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;

        System.out.println("Original Linked List:");
        list.printList(list.head);

        Node clonedHead = list.cloneLinkedList(list.head);

        System.out.println("Cloned Linked List:");
        list.printList(clonedHead);
    }
}
