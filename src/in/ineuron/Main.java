package in.ineuron;
//Node class to represent a node in the linked list
class Node {
 int data;
 Node next;
 
 public Node(int data) {
     this.data = data;
     next = null;
 }
}

//Linked list class
class LinkedList {
 Node head;
 
 // Method to add a node at the end of the linked list
 public void addNode(int data) {
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
 
 // Method to find the Nth node from the end of the linked list
 public int findNthFromEnd(int N) {
     if (head == null || N <= 0) {
         return -1; // Invalid input or empty linked list
     }
     
     Node slow = head;
     Node fast = head;
     
     // Move the fast pointer N nodes ahead
     for (int i = 0; i < N; i++) {
         if (fast == null) {
             return -1; // N is greater than the length of the linked list
         }
         fast = fast.next;
     }
     
     // Move both pointers until the fast pointer reaches the end of the linked list
     while (fast != null) {
         slow = slow.next;
         fast = fast.next;
     }
     
     return slow.data;
 }
}

//Main class
public class Main {
 public static void main(String[] args) {
     LinkedList linkedList = new LinkedList();
     
     // Add nodes to the linked list
     linkedList.addNode(1);
     linkedList.addNode(2);
     linkedList.addNode(3);
     linkedList.addNode(4);
     linkedList.addNode(5);
     linkedList.addNode(6);
     linkedList.addNode(7);
     linkedList.addNode(8);
     linkedList.addNode(9);
     
     int N = 2;
     int result = linkedList.findNthFromEnd(N);
     
     System.out.println("Output: " + result);
 }
}
