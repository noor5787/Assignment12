package in.ineuron.in;
class Node1 {
    int data;
    Node1 next;

    Node1(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedListLoopChecker {
	

	
	    public static boolean hasLoop(Node1 head) {
	        if (head == null || head.next == null) {
	            return false;
	        }

	        Node1 slow = head;
	        Node1 fast = head;

	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;

	            if (slow == fast) {
	                return true;
	            }
	        }

	        return false;
	    }

	    public static void main(String[] args) {
	        // Create the linked list
	        Node1 head = new Node1(1);
	        head.next = new Node1(3);
	        head.next.next = new Node1(4);
	        head.next.next.next = head.next; // Creating a loop

	        boolean hasLoop = hasLoop(head);
	        System.out.println("Has loop: " + hasLoop);
	    }
	}


