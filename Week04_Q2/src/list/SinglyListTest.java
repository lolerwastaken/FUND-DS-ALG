import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SinglyListTest {
    private SinglyList of(int... xs) {
        SinglyList l = new SinglyList();
        for (int x : xs) l.addLast(x);
        return l;
    }

    @Test
    public void testRemoveHead() {
        SinglyList l = of(1,2,3);
        assertTrue(l.remove(1));
        assertArrayEquals(new int[]{2,3}, l.toArray());
        assertEquals(2, l.size());
    }

    @Test
    public void testRemoveMiddleAndTail() {
        SinglyList l = of(1,2,3,4);
        assertTrue(l.remove(3));
        assertArrayEquals(new int[]{1,2,4}, l.toArray());
        assertTrue(l.remove(4));
        assertArrayEquals(new int[]{1,2}, l.toArray());
    }

    @Test
    public void testRemoveAbsentAndOnlyFirstOccurrence() {
        SinglyList l = of(5,7,5);
        assertFalse(l.remove(9));
        assertTrue(l.remove(5));               // removes the first 5 only
        assertArrayEquals(new int[]{7,5}, l.toArray());
    }

    @Test
    public void testRemoveDownToEmpty() {
        SinglyList l = of(42);
        assertTrue(l.remove(42));
        assertTrue(l.isEmpty());
        assertEquals(0, l.size());
        assertFalse(l.remove(42));
    }

    @Test
    public void testFindMiddleOdd() {
        assertEquals(3, of(1,2,3,4,5).findMiddle());
    }

    @Test
    public void testFindMiddleEvenReturnsSecond() {
        assertEquals(3, of(1,2,3,4).findMiddle());   // middle pair (2,3) -> second = 3
    }

    @Test
    public void testFindMiddleEmptyThrows() {
        assertThrows(IllegalStateException.class, () -> new SinglyList().findMiddle());
    }
}
