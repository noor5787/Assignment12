package in.ineuron.a;
class Node {
    char data;
    Node next;
    
    public Node(char data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedListPalindrome {
	


	    Node head;
	    
	    // Function to check if a linked list is a palindrome
	    boolean isPalindrome() {
	        if (head == null) {
	            // Empty list is considered a palindrome
	            return true;
	        }
	        
	        // Find the middle of the linked list
	        Node slowPtr = head;
	        Node fastPtr = head;
	        
	        while (fastPtr.next != null && fastPtr.next.next != null) {
	            slowPtr = slowPtr.next;
	            fastPtr = fastPtr.next.next;
	        }
	        
	        // Reverse the second half of the linked list
	        Node secondHalf = reverseList(slowPtr.next);
	        
	        // Compare the first half and reversed second half
	        Node firstHalf = head;
	        
	        while (secondHalf != null) {
	            if (firstHalf.data != secondHalf.data) {
	                return false; // Not a palindrome
	            }
	            
	            firstHalf = firstHalf.next;
	            secondHalf = secondHalf.next;
	        }
	        
	        return true; // Palindrome
	    }
	    
	    // Function to reverse a linked list
	    Node reverseList(Node node) {
	        Node prev = null;
	        Node curr = node;
	        Node next = null;
	        
	        while (curr != null) {
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        
	        return prev;
	    }
	    
	    // Function to insert a new node at the beginning of the linked list
	    void push(char data) {
	        Node newNode = new Node(data);
	        newNode.next = head;
	        head = newNode;
	    }
	    
	    public static void main(String[] args) {
	        LinkedListPalindrome lList = new LinkedListPalindrome();
	        
	        // Example 1
	        lList.push('R');
	        lList.push('A');
	        lList.push('D');
	        lList.push('A');
	        lList.push('R');
	        
	        if (lList.isPalindrome()) {
	            System.out.println("Yes");
	        } else {
	            System.out.println("No");
	        }
	        
	        // Example 2
	        lList = new LinkedListPalindrome();
	        lList.push('C');
	        lList.push('O');
	        lList.push('D');
	        lList.push('E');
	        
	        if (lList.isPalindrome()) {
	            System.out.println("Yes");
	        } else {
	            System.out.println("No");
	        }
	    }
	}


