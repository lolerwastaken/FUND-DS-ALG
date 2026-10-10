// Given. Do not modify.
import java.util.NoSuchElementException;

public class ListIterator implements Iterator {
    ListNode currentNode;   // the iterator's current position

    ListIterator(ListNode theNode) {
        currentNode = theNode;
    }

    @Override
    public boolean hasNext() {
        return currentNode.nextNode != null;
    }

    @Override
    public int next() throws Exception {
        if (!hasNext())
            throw new NoSuchElementException();
        currentNode = currentNode.nextNode;
        return currentNode.data;
    }

    @Override
    public void set(int value) {
        currentNode.data = value;
    }
}
