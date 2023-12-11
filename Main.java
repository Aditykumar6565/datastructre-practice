// Java program to delete a node in
// singly linked list recursively

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class Main {

	// Deletes the node containing 'data'
	// part as val and alter the head of
	// the linked list (recursive method)
	public static int deleteNode(Node head, int val) {
		// Check if list is empty or we
		// reach at the end of the
		// list.
		if (head == null) {
			System.out.println("Element not present in the list");
			return -1;
		}
		// If current node is the
		// node to be deleted
		if (head.data == val) {
			// If it's start of the node head
			// node points to second node
			if (head.next != null) {
				head.data = head.next.data;
				head.next = head.next.next;
				return 1;
			} else
				return 0;
		}
		if (deleteNode(head.next, val) == 0) {
			head.next = null;
			return 1;
		}
		return -1;
	}

	// Utility function to add a
	// node in the linked list
	// Here we are passing head by
	// reference thus no need to
	// return it to the main function
	public static Node push(Node head, int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		return head;
	}

	// Utility function to print
	// the linked list (recursive
	// method)
	public static void printLL(Node head) {
		if (head == null)
			return;
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// Starting with an empty linked list
		Node head = null;

		// Adds new element at the
		// beginning of the list
		head = push(head, 10);
		head = push(head, 12);
		head = push(head, 14);
		head = push(head, 15);

		// original list
		printLL(head);

		// Call to delete function
		deleteNode(head, 20);

		// 20 is not present thus no change
		// in the list
		printLL(head);

		deleteNode(head, 10);
		printLL(head);

		deleteNode(head, 14);
		printLL(head);
	}
}
