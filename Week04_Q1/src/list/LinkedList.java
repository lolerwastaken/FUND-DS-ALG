/**
 * A singly-linked list of ints with a dummy HEADER node. The header removes
 * special cases: every real element has a predecessor, so insert/remove never
 * have to treat "the first element" differently.
 *
 * insert(value, p) inserts AFTER the node the iterator p currently points at.
 * To insert at the very front, position an iterator at the header.
 *
 * TODO: complete the methods marked TODO. You may NOT use java.util collections
 * or arrays for storage (toArray is a given test helper). Reuse the iterator.
 */
public class LinkedList {
    ListNode header;
    static final int HEADER_MARKER = -9999999;

    public LinkedList() {
        header = new ListNode(HEADER_MARKER);
    }

    /** An iterator positioned at the header (before the first element). Given. */
    public Iterator iterator() {
        return new ListIterator(header);
    }

    /** Given. */
    public boolean isEmpty() {
        return header.nextNode == null;
    }

    /** Given. */
    public void makeEmpty() {
        header.nextNode = null;
    }

    /** Given. */
    public int head() throws Exception {
        if (isEmpty()) throw new Exception();
        return header.nextNode.data;
    }

    /** Given helper for testing: the list's contents, front to back. */
    public int[] toArray() {
        int n = 0;
        for (ListNode c = header.nextNode; c != null; c = c.nextNode) n++;
        int[] out = new int[n];
        ListNode cur = header.nextNode;
        for (int i = 0; i < n; i++) { out[i] = cur.data; cur = cur.nextNode; }
        return out;
    }

    public int size() {
        // TODO: count the elements (not counting the header)
        int total = 0;
        int[] elementList = toArray();

        for (int i = 0; i < elementList.length; i++) total++;

        return total;

        // return toArray().length; (shorter, simpler and also works)
    }

    /** Return the 0-based position of the first occurrence of value, or -1. */
    public int find(int value) throws Exception {
        // TODO: walk with an iterator, tracking the index
        Iterator itr = new ListIterator(header);
        int index = -1;

        while (itr.hasNext()) {
            int v = itr.next();
            index++;
            if (v == value) return index; // return the position of value
        }

        return -1; // return -1 if the value is not in the list
    }

    /** Return the element at 0-based position kthPosition, or throw if out of range. */
    public int findKth(int kthPosition) throws Exception {
        // TODO: throw if kthPosition < 0 or beyond the end
        if (kthPosition < 0)
            throw new Exception(); // exit the method if the position is less than the first possible position, throwing exception in the process.

        Iterator itr = new ListIterator(header);
        int index = -1;

        while (itr.hasNext()) {
            int v = itr.next();
            index++;
            if (index == kthPosition) return v;
        }
        throw new Exception(); // throw exception if out of range
    }

    /** Insert value AFTER the node iterator p points at. */
    public void insert(int value, Iterator p) throws Exception {
        // TODO: validate p, then splice a new ListNode in after p.currentNode
        if (p == null || !(p instanceof ListIterator)) throw new Exception();

        ListIterator p2 = (ListIterator) p;

        if (p2.currentNode == null) throw new Exception();

        ListNode n = new ListNode(value, p2.currentNode.nextNode);

        p2.currentNode.nextNode = n;
    }

    /** Return an iterator pointing at the node BEFORE the first occurrence of value, or null. */
    public Iterator findPrevious(int value) throws Exception {
        // TODO: scan with a "previous" pointer starting at the header
        Iterator itr1 = new ListIterator(header);
        Iterator itr2 = new ListIterator(header);

        if (!itr2.hasNext()) return null;

        int currentData = itr2.next();

        while (currentData != value && itr2.hasNext()) {
            currentData = itr2.next();
            itr1.next();
        }
        if (currentData == value) return itr1;

        return null;
    }

    /** Remove the node AFTER the one iterator p points at (if any). */
    public void remove(Iterator p) {
        // TODO: unlink p.currentNode.nextNode
        if (p == null || !(p instanceof ListIterator)) return;

        ListIterator p2 = (ListIterator) p;

        if (p2.currentNode == null || p2.currentNode.nextNode == null) return;

        p2.currentNode.nextNode = p2.currentNode.nextNode.nextNode;
    }

    /** Remove the first occurrence of value (no-op if absent). */
    public void remove(int value) throws Exception {
        // TODO: use findPrevious + remove(Iterator)

        Iterator p = findPrevious(value); // Method findPrevious attempts to find a node just before the node that stores value.
        // findPrevious returns null if no such node exists.

        if (p == null) return;

        remove(p);
    }
}

/*
1. Write method public void insertAtFront(int x) for class CDLinkedList. This method inserts a new list node
   with data "x" inside, between header and other nodes.

public void insertAtFront(int x) {
    DListIterator itr1 = new DListIterator(header);
    DListIterator itr2 = new DListIterator(header.nextNode);

    DListNode newFrontNode = new DListNode(x, itr2.currentNode, itr1.currentNode); (data, next, previous)

    itr1.currentNode.nextNode = newFrontNode;
    itr2.currentNode.previousNode = newFrontNode;
    size++;
}

2. Write method public int removeAtLast() for class CDLinkedList. This method removes the node at the
   last position from the list, and returns the data stored inside that node as the method's return value.

public int removeAtLast() {
    if (header.previousNode == header) throw new Exception();
    DListNode node1 = header.previousNode;
    DListNode node2 = header.previousNode.previousNode;

    node2.nextNode = header;
    header.previousNode = node2;

    size--;
    return node2.data;
}

3. Write method public CDLinkedList reverseList() for class CDLinkedList. This method returns a new linked list
   that has all elements from *this* list, but the elements are arranged in reverse order. You are allowed to change *this* list.

public CDLinkedList reverseList() {
    CDLinkedList newList = new CDLinkedList();

    DListNode current = header.nextNode;
    while (current != header) {
        DListNode oldFirst = newList.header.nextNode;
        DListNode newNode = new DListNode(current.data, oldFirst, newList.header);

        oldFirst.previousNode = newNode;
        newList.header.nextNode = newNode;
        newList.size++;

        current = current.nextNode;
    }
    return newList;
}

4. Write method public boolean isInFront(int x, int y) for class CDLinkedList. This method returns true if x is stored in some node before y.
   (when we search from left to right, starting from header). It returns false otherwise. If x or y is not in the list, this method returns false.

public boolean isInFront(int x, int y) {
    int xIndex = find(x);
    int yIndex = find(y);

    if (xIndex == -1 || yIndex == -1) return false;

    return xIndex < yIndex; // true is index of x is less than index of y, meaning x comes before y.
}

5. For class LinkedLIst (singly), write method public void setify(). This method changes our list by
   removing all duplicated data so that there is only one copy of each data.

public void setify() {
    ListIterator itr1 = new ListIterator(header);
    while (itr1.hasNext()) {
        int v = itr1.next();
        if (itr1.currentNode == header) break;

        ListIterator itr2 = new ListIterator(itr2.currentNode);
        while (itr2.currentNode.nextNode != header) {
            if (itr2.currentNode.nextNode.data == v) {
                remove(itr2);
            } else {
                itr2.currentNode = itr2.currentNode.nextNode;
            }
        }
    }

}

6. For class CDLinkedList, write method public void removeBefore(DListIterator p). This method removes a node before
   the node marked to by p, but it does not remove header. Do nothing if p is not valid.

public void removeBefore(DListIterator p) {
    if (p == null || p.currentNode == null) return;
    DListIterator beforeNode = new DListIterator(p.currentNode.previousNode);
    remove(beforeNode);
}

*/
