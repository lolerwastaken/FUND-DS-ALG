package LinkedList;

public class DListNode {
    // Constructors
    public DListNode(int data) {
        this(data, null, null);
    }

    public DListNode(int theElement, DListNode n, DListNode p) {
        data = theElement;
        nextNode = n;
        previousNode = p;
    }

    // Friendly data; accessible by other package routines
    public int data;
    public DListNode nextNode, previousNode;
}
