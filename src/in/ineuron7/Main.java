package in.ineuron7;

class Node {
    int data;
    Node next;
  
    Node(int data) {
        this.data = data;
        next = null;
    }
}

class LinkedList {
    Node head;

    void insertAlternate(LinkedList second) {
        Node curr1 = head;
        Node curr2 = second.head;
        Node next1, next2;

        while (curr1 != null && curr2 != null) {
            next1 = curr1.next;
            next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }

        second.head = curr2;
    }

    void display() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList first = new LinkedList();
        first.head = new Node(5);
        first.head.next = new Node(7);
        first.head.next.next = new Node(17);
        first.head.next.next.next = new Node(13);
        first.head.next.next.next.next = new Node(11);

        LinkedList second = new LinkedList();
        second.head = new Node(12);
        second.head.next = new Node(10);
        second.head.next.next = new Node(2);
        second.head.next.next.next = new Node(4);
        second.head.next.next.next.next = new Node(6);

        System.out.print("First List before insertion: ");
        first.display();

        System.out.print("Second List before insertion: ");
        second.display();

        first.insertAlternate(second);

        System.out.print("First List after insertion: ");
        first.display();

        System.out.print("Second List after insertion: ");
        second.display();
    }
}
