import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TestBot {
    @Test
    void testDetailedConstructorLegalValue() { // 2 points
        Part head = new Part(5,2,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);

        Bot b = new Bot(head,arms,legs);

        assertNotEquals(head,b.getHead());
        assertNotEquals(arms,b.getArms());
        assertNotEquals(legs,b.getLegs());

        Part newHead = b.getHead();
        Part newArms = b.getArms();
        Part newLegs = b.getLegs();

        assertEquals(5,newHead.getHp());
        assertEquals(2,newHead.getStr());
        assertEquals(1,newHead.getDef());

        assertEquals(6,newArms.getHp());
        assertEquals(3,newArms.getStr());
        assertEquals(2,newArms.getDef());

        assertEquals(4,newLegs.getHp());
        assertEquals(4,newLegs.getStr());
        assertEquals(3,newLegs.getDef());

    }

    @Test
    void testisDead() { // 1 point
        Part head = new Part(5,2,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);

        Bot b = new Bot(head,arms,legs);
        assertFalse(b.isDead());

        b.getHead().setHp(0);
        assertFalse(b.isDead());

        b.getArms().setHp(0);
        assertFalse(b.isDead());

        b.getLegs().setHp(0);
        assertTrue(b.isDead());

    }

    @Test
    void testSetter() { // 1 point
        Part head = new Part(5,2,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);

        Bot b = new Bot(head,arms,legs);
        Part spareHead1 = new Part(6,3,2);
        Part spareArms1 = new Part(7,4,3);
        Part spareLegs1 = new Part(5,5,4);

        b.setHead(spareHead1);
        Part currentHead = b.getHead();
        assertNotEquals(spareHead1, currentHead);
        assertEquals(6,currentHead.getHp());
        assertEquals(3,currentHead.getStr());
        assertEquals(2,currentHead.getDef());

        b.setArms(spareArms1);
        Part currentArms = b.getArms();
        assertNotEquals(spareArms1, currentArms);
        assertEquals(7,currentArms.getHp());
        assertEquals(4,currentArms.getStr());
        assertEquals(3,currentArms.getDef());

        b.setLegs(spareLegs1);
        Part currentLegs = b.getLegs();
        assertNotEquals(spareLegs1, currentLegs);
        assertEquals(5,currentLegs.getHp());
        assertEquals(5,currentLegs.getStr());
        assertEquals(4,currentLegs.getDef());

    }

    @Test
    void testAttackBaseCase() { // 1 point
        Part head = new Part(5,2,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);

        Bot b = new Bot(head,arms,legs);

        //When target is null.
        Part target = null;
        b.attack(target);
        assertNull(target);

        //When target is already destroyed.
        target = new Part(10,3,2);
        target.setHp(0);
        b.attack(target);
        int targetHp = target.getHp();
        assertEquals(0,targetHp);

    }

    @Test
    void testAttackGeneralCase() { // 2 points
        Part head = new Part(5,4,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);
        Bot b = new Bot(head,arms,legs);

        Part target = new Part(10,3,2);
        b.attack(target);
        int targetHp = target.getHp();
        assertEquals(6,targetHp);

        target = new Part(10,3,4);
        b.attack(target);
        targetHp = target.getHp();
        assertEquals(8,targetHp);

    }

    @Test
    void testAttackDefTooStrong() { // 1 point
        Part head = new Part(5,4,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);
        Bot b = new Bot(head,arms,legs);

        Part target = new Part(10,3,6);
        b.attack(target);
        int targetHp = target.getHp();
        assertEquals(10,targetHp);

        target = new Part(10,3,8);
        b.attack(target);
        targetHp = target.getHp();
        assertEquals(10,targetHp);

    }

    @Test
    void testAttackDestroy() { // 2 points
        Part head = new Part(5,4,1);
        Part arms =  new Part(6,3,2);
        Part legs = new Part(4,4,3);
        Bot b = new Bot(head,arms,legs);

        Part target = new Part(5,3,1);
        b.attack(target);
        int targetHp = target.getHp();
        int targetStr = target.getStr();
        int targetDef = target.getDef();
        assertEquals(0,targetHp);
        assertEquals(0,targetStr);
        assertEquals(0,targetDef);


        target = new Part(2,3,2);
        b.attack(target);
        targetHp = target.getHp();
        assertEquals(0,targetHp);
        assertEquals(0,targetStr);
        assertEquals(0,targetDef);
    }



}
