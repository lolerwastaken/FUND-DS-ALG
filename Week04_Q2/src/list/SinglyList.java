/**
 * A singly-linked list WITHOUT a dummy header (head points straight at the first
 * node, or is null when empty). Unlike the header list of Q1, remove() must treat
 * the FIRST node as a special case — the very trade-off a header node removes.
 *
 * TODO: complete remove() and findMiddle(). addLast/contains/toArray/size are given.
 */
public class SinglyList {
    private static class Node {
        int data; Node next;
        Node(int d, Node n) { data = d; next = n; }
    }
    private Node head;
    private int size;

    public boolean isEmpty() { return head == null; }
    public int size()        { return size; }

    public void addLast(int v) {
        Node n = new Node(v, null);
        if (head == null) { head = n; size++; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
        size++;
    }

    public boolean contains(int v) {
        for (Node c = head; c != null; c = c.next) if (c.data == v) return true;
        return false;
    }

    /** Remove the FIRST occurrence of v; return true if something was removed.
     *  Handle the case where the match is the head node. */
    public boolean remove(int v) {
        // TODO
        if (head == null) return false; // Head node cannot be null (empty)

        if (head.data == v) { // Handles case where the head node is removed
            head = head.next;
            size--;
            return true;
        }

        Node current = head.next;

        while (current != null) { // Checks the rest of the list
            if (current.next != null && current.next.data == v) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    /** Middle element via slow/fast pointers. Even count -> SECOND middle.
     *  Throw IllegalStateException if empty. */
    public int findMiddle() {
        if (head == null) throw new IllegalStateException("Empty list.");

        // Slow and fast pointers (slow moves 1 node ahead and fast moves 2 nodes ahead)
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;

        // Determines the middle element by checking the slow element.
        // Example: [1, 2, 3, 4]
        // first trace: slow: 1, fast: 1 --> condition: fast = 1 and fast.next = 2 --> slow = 2, fast = 3
        // second trace: slow: 2, fast: 3 --> condition: fast = 3 and fast.next = 3 --> slow = 3, fast = null
        // third trace: slow: 3, fast: null --> stop the loop, fast cannot be null
        // Thus, the middle value is 3. (uses second middle in an even list)
    }

    public int[] toArray() {
        int[] out = new int[size];
        int i = 0;
        for (Node c = head; c != null; c = c.next) out[i++] = c.data;
        return out;
    }
}
