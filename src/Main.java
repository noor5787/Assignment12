
class Node {
    int data;
    Node next;

    Node(int value) {
        data = value;
        next = null;
    }
}

class LinkedList {
    Node head;

    void insert(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void createLoop(int position) {
        if (position == 0)
            return;
        Node currentNode = head;
        Node loopNode = null;
        int count = 1;

        while (currentNode.next != null) {
            if (count == position) {
                loopNode = currentNode;
            }
            currentNode = currentNode.next;
            count++;
        }

        if (loopNode != null) {
            currentNode.next = loopNode;
        }
    }

    boolean detectAndRemoveLoop() {
        if (head == null || head.next == null)
            return false;

        Node slow = head;
        Node fast = head;

        // Detecting the loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        // If loop not found
        if (slow != fast)
            return false;

        // Removing the loop
        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = null; // Breaking the loop

        return true;
    }

    void display() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Example 1
        list.insert(1);
        list.insert(3);
        list.insert(4);
        list.createLoop(2);
        System.out.print("Input: ");
        list.display();
        list.detectAndRemoveLoop();
        System.out.print("Output: ");
        list.display();

        // Example 2
        list = new LinkedList();
        list.insert(1);
        list.insert(8);
        list.insert(3);
        list.insert(4);
        list.createLoop(0);
        System.out.print("Input: ");
        list.display();
        list.detectAndRemoveLoop();
        System.out.print("Output: ");
        list.display();
    }
}
