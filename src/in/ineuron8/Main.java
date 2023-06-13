package in.ineuron8;
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
    
    // Function to insert a node at the end of the linked list
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
    
    // Function to check if the linked list is circular
    public boolean isCircular() {
        if (head == null) {
            return false;
        }
        
        Node slow = head;
        Node fast = head.next;
        
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        
        // Make the linked list circular
        list.head.next.next.next.next = list.head;
        
        boolean isCircular = list.isCircular();
        if (isCircular) {
            System.out.println("The linked list is circular.");
        } else {
            System.out.println("The linked list is not circular.");
        }
    }
}
