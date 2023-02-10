package DataStructure;

public class LinkedListNode {

	int data;
	LinkedListNode link;

	public LinkedListNode() {
		
	}
	
	public LinkedListNode(int data) {
		this.data = data;
	}
	
	public LinkedListNode(int data, LinkedListNode target) {
		this.data = data;
		this.link = target;
	}
}
