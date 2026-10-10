import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestPart {

    @Test
    void testDetailedConstructorLegalValue() { // 1 point
        Part p = new Part(5, 2, 1);
        assertEquals(5, p.getHp());
        assertEquals(2, p.getStr());
        assertEquals(1, p.getDef());

    }

    @Test
    void testDetailedConstructorIllegalValue() { // 1 point
        Part p = new Part(-5, -2, -1);
        assertEquals(0, p.getHp());
        assertEquals(0, p.getStr());
        assertEquals(0, p.getDef());

    }

    @Test
    void testDefaultConstructor() { // 1 point
        Part p = new Part();
        assertEquals(10, p.getHp());
        assertEquals(2, p.getStr());
        assertEquals(2, p.getDef());

    }

    @Test
    void testSetterLegalValue() { // 1 point
        Part p = new Part();
        p.setHp(5);
        p.setStr(7);
        p.setDef(9);

        assertEquals(5, p.getHp());
        assertEquals(7, p.getStr());
        assertEquals(9, p.getDef());

    }

    @Test
    void testSetterHpZero() { // 2 point
        Part p = new Part();
        p.setHp(0);

        assertEquals(0, p.getHp());
        assertEquals(0, p.getStr());
        assertEquals(0, p.getDef());

        p.setStr(7);
        p.setDef(9);
        assertEquals(0, p.getStr());
        assertEquals(0, p.getDef());
    }


    @Test
    void testSetterIllegalValue() {// 1 point
        Part p = new Part();
        p.setHp(-5);
        p.setStr(-7);
        p.setDef(-9);

        assertEquals(0, p.getHp());
        assertEquals(0, p.getStr());
        assertEquals(0, p.getDef());

    }


}
