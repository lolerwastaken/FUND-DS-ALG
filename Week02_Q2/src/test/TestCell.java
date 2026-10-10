import entity.Cell;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestCell {

    @Test
    void testDefaultConstructor(){ //1 point
        Cell c = new Cell();
        assertEquals(5,c.getHp());
        assertEquals(2,c.getAttack());
        assertEquals(1,c.getDef());
    }

    @Test
    void testDetailedConstructor(){ //1 point
        Cell c = new Cell(6,4,3);
        assertEquals(6,c.getHp());
        assertEquals(4,c.getAttack());
        assertEquals(3,c.getDef());
    }

    @Test
    void testDetailedConstructorIllegalValue(){ //1 point
        Cell c = new Cell(-1,-1,-1);
        assertEquals(0,c.getHp());
        assertEquals(0,c.getAttack());
        assertEquals(0,c.getDef());
    }
}
