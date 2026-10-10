import entity.CancerCell;
import entity.Cell;
import entity.EaterCell;
import entity.WhiteBloodCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestCancerCell {
    @Test
    void test2ParamConstructor() { // 1 point
        CancerCell c = new CancerCell(6,2);
        assertEquals(5, c.getHp());
        assertEquals(2, c.getAttack());
        assertEquals(1, c.getDef());
        assertEquals(6, c.getDivideInterval());
        assertEquals(2, c.getEatingSpeed());
        assertEquals(0, c.getDivideCounter());
        assertFalse(c.isDivideSuccess());
    }


    @Test
    void test2ParamConstructorIllegalValue() { // 1 point
        CancerCell c = new CancerCell(-6,-2);
        assertEquals(5, c.getHp());
        assertEquals(2, c.getAttack());
        assertEquals(1, c.getDef());
        assertEquals(0, c.getDivideInterval());
        assertEquals(0, c.getEatingSpeed());
        assertEquals(0, c.getDivideCounter());
        assertFalse(c.isDivideSuccess());
    }

    @Test
    void testDetailedConstructor() { // 1 point
        CancerCell c = new CancerCell(6,3,2,7,3);
        assertEquals(6, c.getHp());
        assertEquals(3, c.getAttack());
        assertEquals(2, c.getDef());
        assertEquals(7, c.getDivideInterval());
        assertEquals(3, c.getEatingSpeed());
        assertEquals(0, c.getDivideCounter());
        assertFalse(c.isDivideSuccess());
    }

    @Test
    void testDetailedConstructorIllegalValue() { // 1 point
        CancerCell c = new CancerCell(-6,-3,-2,-7,-3);
        assertEquals(0, c.getHp());
        assertEquals(0, c.getAttack());
        assertEquals(0, c.getDef());
        assertEquals(0, c.getDivideInterval());
        assertEquals(0, c.getEatingSpeed());
        assertEquals(0, c.getDivideCounter());
        assertFalse(c.isDivideSuccess());
    }

    @Test
    void testSuck() { // 8 points
        CancerCell eater = new CancerCell(5,3,2,6, 2);
        Cell c1 = new Cell();
        Cell c2 = new WhiteBloodCell(9, 1, 2);

        eater.suck(c1);
        assertEquals(9, eater.getHp());
        assertEquals(1, c1.getHp());
        assertEquals(2, eater.getDivideCounter());

        eater.suck(c2);
        assertEquals(11, eater.getHp());
        assertEquals(7, c2.getHp());
        assertEquals(4, eater.getDivideCounter());

        Cell c3 = new CancerCell(9, 1, 2,4,2);
        eater.suck(c3);
        assertEquals(11, eater.getHp());
        assertEquals(9, c3.getHp());
        assertEquals(4, eater.getDivideCounter());

        eater.suck(c1);
        assertEquals(12, eater.getHp());
        assertEquals(0, c1.getHp());
        assertEquals(6, eater.getDivideCounter());
        assertTrue(eater.isDivideSuccess());


    }

    @Test
    void testMutate() { // 1 point
        CancerCell eater = new CancerCell(5,3,2,6, 2);
        eater.mutate();
        assertEquals(3,eater.getEatingSpeed());
        eater.mutate();
        assertEquals(4,eater.getEatingSpeed());

    }

}
