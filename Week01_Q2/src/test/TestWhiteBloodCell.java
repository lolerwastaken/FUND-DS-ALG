import entity.CancerCell;
import entity.Cell;
import entity.EaterCell;
import entity.WhiteBloodCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestWhiteBloodCell {
    @Test
    void testDefaultConstructor() { // 1 point
        EaterCell c = new WhiteBloodCell();
        assertEquals(5, c.getHp());
        assertEquals(2, c.getAttack());
        assertEquals(1, c.getDef());
    }

    @Test
    void testDetailedConstructor() { // 1 point
        Cell c = new WhiteBloodCell(6, 4, 3);
        assertEquals(6, c.getHp());
        assertEquals(4, c.getAttack());
        assertEquals(3, c.getDef());
    }

    @Test
    void testDetailedConstructorIllegalValue() { //1 point
        Cell c = new WhiteBloodCell(-1, -1, -1);
        assertEquals(0, c.getHp());
        assertEquals(0, c.getAttack());
        assertEquals(0, c.getDef());
    }

    @Test
    void testSuck() { // 5 points
        WhiteBloodCell eater = new WhiteBloodCell(5, 3, 1);
        Cell c1 = new Cell();
        Cell c2 = new CancerCell(9,2);

        eater.suck(c1);
        assertEquals(7, eater.getHp());
        assertEquals(3, c1.getHp());

        eater.suck(c2);
        assertEquals(9, eater.getHp());
        assertEquals(3, c2.getHp());

        Cell c3 = new WhiteBloodCell(9, 1, 2);
        eater.suck(c3);
        assertEquals(9, eater.getHp());
        assertEquals(9, c3.getHp());


    }
}