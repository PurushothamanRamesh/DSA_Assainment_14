class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

public class Question6 {
    Node leftShiftLinkedList(Node head, int k) {
        if (head == null || k <= 0)
            return head;

        int length = 0;
        Node curr = head;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        int effectiveShifts = k % length;
        if (effectiveShifts == 0)
            return head;

        Node newHead = head;
        for (int i = 0; i < effectiveShifts; i++) {
            newHead = newHead.next;
        }

        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        tail.next = head;
        Node newTail = newHead;
        while (newTail.next != newHead) {
            newTail = newTail.next;
        }
        newTail.next = null;

        return newHead;
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Question6 list = new Question6();
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(7);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(9);

        int k = 3;

        System.out.println("Original Linked List:");
        list.printList(head);

        Node modifiedHead = list.leftShiftLinkedList(head, k);

        System.out.println("Modified Linked List:");
        list.printList(modifiedHead);
    }
}
