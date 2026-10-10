package stack;

import linkedlist.CDLinkedList;
import linkedlist.DListIterator;
import myInterface.Iterator;
import myInterface.MyStack;

public class StackLinkedList implements MyStack {
	private CDLinkedList theList;
	
	public StackLinkedList(){ // create an empty stack
		theList = new CDLinkedList();
	}
	
	public StackLinkedList(CDLinkedList l) throws Exception {
		super();
		DListIterator iparam = new DListIterator(l.header);
		DListIterator ithis = new DListIterator(theList.header);
		while (iparam.hasNext()) {
			int v = iparam.next();
			if (iparam.currentNode == l.header)
				return;
			theList.insert(v, ithis);
			ithis.next();
		}	
	}
	
	public CDLinkedList getTheList() {
		return theList;
	}

	public void setTheList(CDLinkedList theList) {
		this.theList = theList;
	}

	public boolean isEmpty(){
		return theList.isEmpty();
	}
	
	public boolean isFull(){
		return false;
	}
	
	public void makeEmpty(){
		theList.makeEmpty();
	}
	
	public int top() throws MyStackException {
		if(isEmpty())
			throw new MyStackException();
		return theList.header.nextNode.data;
	}
	
	public void pop() throws MyStackException {
		if(isEmpty())
			throw new MyStackException();
		Iterator itr = new DListIterator(theList.header);
		theList.remove(itr);
	}
	
	public void push(int data) throws Exception{
		Iterator itr = new DListIterator(theList.header);
		theList.insert(data, itr);
	}

    public void removeRange(int i, int j) throws Exception {
        if (i < 0 || i > j) throw new Exception(); // Range index 'i' cannot be less than 0 or more than 'j' index

        DListIterator itr = new DListIterator(theList.header);
        int index = 0;
        while (index < i && itr.hasNext()) { // Check if the index is before i and if itr.hasNext() is valid
            itr.next(); // Move itr to the next node until it lands right before the range index
            index++; // Increment the index by 1
        }

        int rangeSize = j - i + 1;
        DListIterator before = new DListIterator(itr.currentNode);
        DListIterator after = new DListIterator(itr.currentNode);
        // Can also use DListNode logic instead of DListIterator

        for (int k = 0; k <= rangeSize; k++) {
            after.next(); // Move the after iterator until it's outside the removal range
        }

        // Join the "before" and "after" nodes together, unlinking the nodes within range (range removal is done)
        before.currentNode.nextNode = after.currentNode;
        after.currentNode.previousNode = before.currentNode;

        theList.size -= rangeSize; // Reduce the total list size by the range size

    }
}
