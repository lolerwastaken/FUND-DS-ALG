package bst;

public class BSTNode {
	public int data; // value stored in the node.
	public BSTNode left; //pointer to lower left BSTNode.
	public BSTNode right; //pointer to lower right BSTNode.
	public BSTNode parent; //pointer to the BSTNode above.

	public BSTNode(int data){
		this(data,null,null,null);
	}
	
	public BSTNode(int data, BSTNode left, BSTNode right, BSTNode parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}
	
	
	
	
	public static void main(String[] args) {
		BSTNode b = new BSTNode(9); 
	}
}
