public class CDLinkedList {
	DListNode header;
	int size;
	static final int HEADERVALUE = -9999999;

	public CDLinkedList() {
		header = new DListNode(HEADERVALUE);
		makeEmpty();// necessary, otherwise next/previous node will be null
	}

	public boolean isEmpty() {
		return header.nextNode == header;
	}

	public boolean isFull() {
		return false;
	}

	/** make the list empty. */
	public void makeEmpty() {
		header.nextNode = header;
		header.previousNode = header;
		size =0;
	}

	// put in new data after the position of p.
	public void insert(int value, Iterator p) throws Exception {
		if (p == null || !(p instanceof DListIterator))
			throw new Exception();
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			throw new Exception();

		DListIterator p3 = new DListIterator(p2.currentNode.nextNode);
		DListNode n = new DListNode(value, p3.currentNode, p2.currentNode);
		p2.currentNode.nextNode = n;
		p3.currentNode.previousNode = n;
		size++;
	}

	// return position number of value found in the list.
	// otherwise, return -1.
	public int find(int value) throws Exception {
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				return -1;
			if (v == value)
				return index; // return the position of value.
		}
		return -1;
	}

	// return data stored at kth position.
	public int findKth(int kthPosition) throws Exception {
		if (kthPosition < 0 || kthPosition > size-1)
			throw new Exception();// exit the method if the position is
		// beyond the first/last possible
		// position, throwing exception in the process.
		DListIterator itr = new DListIterator(header);
		int index = -1;
		while (itr.hasNext()) {
			int v = itr.next();
			index++;
			if (itr.currentNode == header)
				throw new Exception();
			if (index == kthPosition)
				return v;
		}
		throw new Exception();
	}

	// Return iterator at position before the first position that stores value.
	// If the value is not found, return null.
	public Iterator findPrevious(int value) throws Exception {
		if (isEmpty())
			return null;
		Iterator itr1 = new DListIterator(header);
		Iterator itr2 = new DListIterator(header);
		int currentData = itr2.next();
		while (currentData != value) {
			currentData = itr2.next();
			itr1.next();
			if (((DListIterator) itr2).currentNode == header)
				return null;
		}
		return itr1;
	}

	// remove content at position just after the given iterator. Skip header if
	// found.
	public void remove(Iterator p) {
		if (isEmpty())
			return;
		if (p == null || !(p instanceof DListIterator))
			return;
		DListIterator p2 = (DListIterator) p;
		if (p2.currentNode == null)
			return;
		if (p2.currentNode.nextNode == header)
			p2.currentNode = header;
		if (p2.currentNode.nextNode == null)
			return;
		DListIterator p3 = new DListIterator(p2.currentNode.nextNode.nextNode);
		p2.currentNode.nextNode = p3.currentNode;
		p3.currentNode.previousNode = p2.currentNode;
		size--;
	}

	// remove the first instance of the given data.
	public void remove(int value) throws Exception {
		Iterator p = findPrevious(value);
		if (p == null)
			return;
		remove(p);
	}

	// remove data at position p.
	// if p points to header or the list is empty, do nothing.
	public void removeAt(Iterator p) throws Exception {
		if (isEmpty() || p == null || !(p instanceof DListIterator) || ((DListIterator) p).currentNode == null
				|| ((DListIterator) p).currentNode == header)
			return;

		DListIterator p2 = (DListIterator) (findPrevious(p));
		remove(p2);

	}

	// Print each contact out, one by one.
	// To be completed by students.
	public void printList() throws Exception {
		Iterator itr = new DListIterator(header);
		while (itr.hasNext()) {
			Object data = itr.next();

			System.out.println(data);

		}
	}

	public int size() throws Exception {
		return size;
	}

	// return iterator pointing to location before position.
	public Iterator findPrevious(Iterator position) throws Exception {
		if (position == null)
			return null;
		if (!(position instanceof DListIterator))
			return null;
		if (((DListIterator) position).currentNode == null)
			return null;

		DListIterator p = ((DListIterator) position);
		DListIterator p2 = new DListIterator(p.currentNode.previousNode);
		return p2;

	}
	
	public void swapRange(Iterator start1, Iterator finish1, Iterator start2, Iterator finish2) {
        if (start1 == null || start2 == null || finish1 == null || finish2 == null) return;
        if (!(start1 instanceof DListIterator) || !(start2 instanceof DListIterator) || !(finish1 instanceof DListIterator) || !(finish2 instanceof DListIterator)) return;
        // iterators cannot be null or not an instance of DListIterator, does nothing

        // Unwrap iterators to doubly list nodes f o r switching the ranges
		DListNode s1 = ((DListIterator) start1).currentNode;
        DListNode f1 = ((DListIterator) finish1).currentNode;
        DListNode s2 = ((DListIterator) start2).currentNode;
        DListNode f2 = ((DListIterator) finish2).currentNode;

        // Denote neighboring nodes outside the range
        DListNode prev_s1 = s1.previousNode;
        DListNode next_f1 = f1.nextNode;

        DListNode prev_s2 = s2.previousNode;
        DListNode next_f2 = f2.nextNode;

        if (f1.nextNode == s2) { // handle case where list 1 and list 2 are next to each other (list 1 comes 'be f o r e' list 1)
            // next_f1 and prev_s2 not used here
            prev_s1.nextNode = s2;
            next_f2.previousNode = f1;

            f2.nextNode = s1;
            s1.previousNode = f2;

            f1.nextNode = next_f2;
            s2.previousNode = prev_s1;
        } else if (f2.nextNode == s1) { // handle case where list 2 and list 1 are next to each other (list 2 comes 'be f o r e' list 1)
            // next_f2 and prev_s1 not used here
            prev_s2.nextNode = s1;
            next_f1.previousNode = f2;

            f1.nextNode = s2;
            s2.previousNode = f1;

            s1.previousNode = prev_s2;
            f2.nextNode = next_f1;
        } else { // handle all other cases where the lists are not next to each other
            s2.previousNode = prev_s1;
            f2.nextNode = next_f1;

            s1.previousNode = prev_s2;
            f1.nextNode = next_f2;

            prev_s1.nextNode = s2;
            next_f1.previousNode = f2;

            prev_s2.nextNode = s1;
            next_f2.previousNode = f1;
            // i'm not gonna bother adding notes to every line, just use logic based ob the picture, it just works
        }
	}
}