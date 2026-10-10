
public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	//change the nth data (counting from header) to be a new first 
	//data of the list 
	public void shift(int n) throws Exception {
		if (n < 1 || n > size) throw new Exception("Invalid position"); // position 'n' cannot be out of bounds
		if (n == 1) return; // already first node, list won't be shifted
		DListNode current = header.nextNode; // start at first current node
		for (int i = 1; i < n; i++) { // index of first position is 1, not 0 (not counting header)
			current = current.nextNode; // Iterate every node before n'th node
		}
		shift(current); // shift the current node using the method from problem 1
	}

	// shift the list such that the data at position newStart becomes the first data
	// for list a,b,c,d,e,f
	// if newStart is pointing at c, 
	// the new list will be c,d,e,f,a,b
	public void shift(DListNode newStart) {
		if (newStart == null) return; // New starting node cannot be null

		if (newStart == header.nextNode) return; // Return same list

		DListNode oldStart = header.nextNode; // Old start (first) node
		DListNode oldEnd = header.previousNode; // Old end (last) node
		DListNode newEnd = newStart.previousNode; // New end (last) node

		header.nextNode = newStart; // Make the new starting node the first node of the new list
		newStart.previousNode = header; // Make sure the previous node of new start is header

		// Join old end node with old start node
		oldEnd.nextNode = oldStart;
		oldStart.previousNode = oldEnd;

		newEnd.nextNode = header; // circle new end node back to header
		header.previousNode = newEnd; // circle header back to new end node, ensure the list is circular

	}

}
