import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Grader for the singly-linked LinkedList. */
public class LinkedListTest {

    /** Build a list 10,20,30,... in order using insert + an advancing iterator. */
    private LinkedList build(int... vals) throws Exception {
        LinkedList l = new LinkedList();
        Iterator p = l.iterator();          // at header
        for (int v : vals) {
            l.insert(v, p);                 // insert after current position
            p.next();                       // advance onto the node just inserted
        }
        return l;
    }

    @Test
    public void testEmpty() throws Exception {
        LinkedList l = new LinkedList();
        assertTrue(l.isEmpty());
        assertEquals(0, l.size());
    }

    @Test
    public void testInsertOrderAndSize() throws Exception {
        LinkedList l = build(10, 20, 30);
        assertFalse(l.isEmpty());
        assertEquals(3, l.size());
        assertArrayEquals(new int[]{10, 20, 30}, l.toArray());
        assertEquals(10, l.head());
    }

    @Test
    public void testInsertAtFront() throws Exception {
        LinkedList l = build(10, 20, 30);
        l.insert(5, l.iterator());          // after header == new front
        assertArrayEquals(new int[]{5, 10, 20, 30}, l.toArray());
    }

    @Test
    public void testFind() throws Exception {
        LinkedList l = build(10, 20, 30);
        assertEquals(0, l.find(10));
        assertEquals(2, l.find(30));
        assertEquals(-1, l.find(99));
    }

    @Test
    public void testFindKth() throws Exception {
        LinkedList l = build(10, 20, 30);
        assertEquals(20, l.findKth(1));
        assertThrows(Exception.class, () -> l.findKth(5));
        assertThrows(Exception.class, () -> l.findKth(-1));
    }

    @Test
    public void testFindPrevious() throws Exception {
        LinkedList l = build(10, 20, 30);
        ListIterator prev = (ListIterator) l.findPrevious(20);
        assertEquals(10, prev.currentNode.data);
        assertNull(l.findPrevious(99));
    }

    @Test
    public void testRemoveMiddle() throws Exception {
        LinkedList l = build(10, 20, 30);
        l.remove(20);
        assertArrayEquals(new int[]{10, 30}, l.toArray());
        assertEquals(2, l.size());
    }

    @Test
    public void testRemoveHead() throws Exception {
        LinkedList l = build(10, 20, 30);
        l.remove(10);
        assertArrayEquals(new int[]{20, 30}, l.toArray());
        assertEquals(20, l.head());
    }

    @Test
    public void testRemoveAbsentIsNoOp() throws Exception {
        LinkedList l = build(10, 20, 30);
        l.remove(99);
        assertArrayEquals(new int[]{10, 20, 30}, l.toArray());
    }

    @Test
    public void testMakeEmpty() throws Exception {
        LinkedList l = build(10, 20, 30);
        l.makeEmpty();
        assertTrue(l.isEmpty());
        assertEquals(0, l.size());
    }
}
