import entity.Cell;
import entity.EaterCell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestEaterCell {
    @Test
    void testDefaultConstructor(){ //1 point
        Cell c = new EaterCell();
        assertEquals(5,c.getHp());
        assertEquals(2,c.getAttack());
        assertEquals(1,c.getDef());
    }

    @Test
    void testDetailedConstructor(){ //1 point
        Cell c = new EaterCell(6,4,3);
        assertEquals(6,c.getHp());
        assertEquals(4,c.getAttack());
        assertEquals(3,c.getDef());
    }

    @Test
    void testDetailedConstructorIllegalValue(){ //1 point
        Cell c = new EaterCell(-1,-1,-1);
        assertEquals(0,c.getHp());
        assertEquals(0,c.getAttack());
        assertEquals(0,c.getDef());
    }

    @Test
    void testSuck(){ // 4 points
        EaterCell eater = new EaterCell(5,3,1);
        Cell c1 = new Cell();
        Cell c2 = new Cell(9,1,2);
        Cell c3 = new Cell(1,1,1);

        eater.suck(c1);
        assertEquals(7,eater.getHp());
        assertEquals(3,c1.getHp());

        eater.suck(c2);
        assertEquals(8,eater.getHp());
        assertEquals(8,c2.getHp());

        eater.suck(c3);
        assertEquals(9,eater.getHp());
        assertEquals(0,c3.getHp());

    }



}
