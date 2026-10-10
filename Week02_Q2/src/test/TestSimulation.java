import entity.CancerCell;
import entity.Cell;
import entity.EaterCell;
import entity.WhiteBloodCell;
import main.Simulation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSimulation {

    @Test
    void testMutateAllCancer() { // 4 points
        WhiteBloodCell w1 = new WhiteBloodCell();
        w1.setAttack(4);
        WhiteBloodCell w2 = new WhiteBloodCell();
        CancerCell c1 = new CancerCell(6,3);
        CancerCell c2 = new CancerCell(6,2);

        Cell[] mySlide = Simulation.slide = new Cell[5];
        mySlide[0] = w1;
        mySlide[1] = w2;
        mySlide[2] = c1;
        mySlide[3] = new Cell();
        mySlide[4] = c2;

        Simulation.mutateAllCancerCells();
        assertEquals(4,c1.getEatingSpeed());
        assertEquals(3,c2.getEatingSpeed());

    }

    @Test
    void testAllCancerDead() { // 5 points
        WhiteBloodCell w1 = new WhiteBloodCell();
        w1.setAttack(4);
        WhiteBloodCell w2 = new WhiteBloodCell();
        CancerCell c1 = new CancerCell(6,3);
        CancerCell c2 = new CancerCell(6,2);

        Cell[] mySlide = Simulation.slide = new Cell[5];
        mySlide[0] = w1;
        mySlide[1] = w2;
        mySlide[2] = c1;
        mySlide[3] = new Cell();
        mySlide[4] = c2;

        c1.setHp(0);
        assertFalse(Simulation.allCancerDead());
        c2.setHp(0);
        assertTrue(Simulation.allCancerDead());

    }




}