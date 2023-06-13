package in.ineuron.in;


class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
        	Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void deleteMiddle() {
        if (head == null || head.next == null) {
            // Return null if the list is empty or has only one node
            head = null;
            return;
        }

        Node slowPtr = head;
        Node fastPtr = head;
        Node prev = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prev = slowPtr;
            slowPtr = slowPtr.next;
        }

        // If the list has even number of nodes, delete the second middle node
        if (fastPtr != null) {
            prev.next = slowPtr.next;
        } else {
            // If the list has odd number of nodes, delete the middle node
            prev.next = slowPtr.next;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
        }

public class Main {

	public static void main(String[] args) {
		 LinkedList list1 = new LinkedList();
	        list1.insert(1);
	        list1.insert(2);
	        list1.insert(3);
	        list1.insert(4);
	        list1.insert(5);
	        System.out.print("Input: ");
	        list1.display();
	        list1.deleteMiddle();
	        System.out.print("Output: ");
	        list1.display();

	        LinkedList list2 = new LinkedList();
	        list2.insert(2);
	        list2.insert(4);
	        list2.insert(6);
	        list2.insert(7);
	        list2.insert(5);
	        list2.insert(1);
	        System.out.print("Input: ");
	        list2.display();
	        list2.deleteMiddle();
	        System.out.print("Output: ");
	        list2.display();

	}

}
