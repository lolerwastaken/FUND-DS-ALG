package LinkedList;

public class DListNode {
	public int data;
	public DListNode nextNode;
	public DListNode previousNode;

	public DListNode(int data) {
		this(data, null, null);
	}

	public DListNode(int theElement, DListNode n, DListNode p) {
		data = theElement;
		nextNode = n;
		previousNode = p;
	}

}
