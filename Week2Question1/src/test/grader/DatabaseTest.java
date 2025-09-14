package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Database;
import logic.Player;
import logic.Region;

class DatabaseTest {

	Database d;

	Player p;
	Region r;

	@BeforeEach
	void setUp() throws Exception {
		// Set the database information manually
		ArrayList<Region> testRegionList = new ArrayList<Region>();
		ArrayList<Player> testPlayerList = new ArrayList<Player>();

		r = new Region("Kanto");
		testRegionList.add(r);
		testRegionList.add(new Region("Johto"));

		p = new Player("Red");
		testPlayerList.add(p);
		r.addPlayerToRegion(p);

		Player p2 = new Player("Green");
		testPlayerList.add(p2);
		r.addPlayerToRegion(p2);

		d = new Database(testPlayerList, testRegionList);
	}
	
	@Test
	void testConstructorDefault() {
		d = new Database();
		assertEquals(0,d.getPlayerList().size());
		assertEquals(0,d.getRegionList().size());
	}
	
	@Test
	void testConstructorDetailed() {
		assertEquals(2,d.getPlayerList().size());
		assertEquals(2,d.getRegionList().size());
		assertEquals("Kanto",d.getRegionList().get(0).getName());
		assertEquals("Johto",d.getRegionList().get(1).getName());
	}
	
	@Test
	void testAddPlayer() throws Exception {
		d.addPlayer("Blue", r);

		// The total player list increases
		assertEquals(3, d.getPlayerList().size());
		ArrayList<Player> pList = d.getPlayerList();
		assertEquals("Blue", pList.get(2).getName());
		assertEquals(0, pList.get(2).getScore());
		assertNull(pList.get(2).getCurrentQuest());

		// The region's own player list should also increases
		assertEquals(3, r.getPlayerCount());
		ArrayList<Player> regionPList = r.getPlayerList();
		assertEquals("Blue", regionPList.get(2).getName());
		assertEquals(0, regionPList.get(2).getScore());
		assertNull(regionPList.get(2).getCurrentQuest());

		d.addPlayer("Yellow", r);
		// The total player list increases
		assertEquals(4, d.getPlayerList().size());
		ArrayList<Player> pList2 = d.getPlayerList();
		assertEquals("Yellow", pList2.get(3).getName());
		assertEquals(0, pList2.get(3).getScore());
		assertNull(pList2.get(3).getCurrentQuest());

		// The region's own player list should also increases
		assertEquals(4, r.getPlayerCount());
		ArrayList<Player> regionPList2 = r.getPlayerList();
		assertEquals("Yellow", regionPList2.get(3).getName());
		assertEquals(0, regionPList2.get(3).getScore());
		assertNull(regionPList2.get(3).getCurrentQuest());

	}

	@Test
	void testAddPlayerRepeat() throws Exception {
		d.addPlayer("Blue", r);

		assertThrows(Exception.class, () -> d.addPlayer("Blue", r));

		// Both player lists should not be increased from the earlier repeated addition
		assertEquals(3, d.getPlayerList().size());
		assertEquals(3, r.getPlayerCount());
	}

	@Test
	void testAddRegion() {
		assertEquals(true, d.addRegion("Hoenn"));
		assertEquals(3, d.getRegionList().size());
		Region newRegion = d.getRegionByName("Hoenn");
		assertEquals("Hoenn", newRegion.getName());
		assertEquals(0, newRegion.getPlayerList().size());
		assertEquals(0, newRegion.getQuestList().size());
		
		assertEquals(true, d.addRegion("Sinnoh"));
		assertEquals(4, d.getRegionList().size());
		Region newRegion2 = d.getRegionByName("Sinnoh");
		assertEquals("Sinnoh", newRegion2.getName());
		assertEquals(0, newRegion2.getPlayerList().size());
		assertEquals(0, newRegion2.getQuestList().size());

	}

	@Test
	void testAddRegionRepeat() {
		assertEquals(true, d.addRegion("Hoenn"));
		assertEquals(3, d.getRegionList().size());
		assertEquals(false, d.addRegion("Hoenn"));
		assertEquals(3, d.getRegionList().size());
	}

	@Test
	void testAddQuest() {
		d.addQuest(p, r, "TestAdd", "AddQuest");
		assertEquals(1, r.getQuestList().size());
		assertEquals("TestAdd", r.getQuestList().get(0).getName());
		assertEquals("AddQuest", r.getQuestList().get(0).getDescription());

		d.addQuest(p, r, "TestAdd2", "AddQuest2");
		assertEquals(2, r.getQuestList().size());
		assertEquals("TestAdd", r.getQuestList().get(0).getName());
		assertEquals("AddQuest", r.getQuestList().get(0).getDescription());
		assertEquals("TestAdd2", r.getQuestList().get(1).getName());
		assertEquals("AddQuest2", r.getQuestList().get(1).getDescription());

	}

	@Test
	void testGetPlayerList() {
		ArrayList<Player> result = d.getPlayerList();
		assertEquals(2, result.size());

		assertEquals("Red", result.get(0).getName());
		assertEquals("Green", result.get(1).getName());
	}

	@Test
	void testGetRegionList() {
		ArrayList<Region> result = d.getRegionList();
		assertEquals(2, result.size());

		assertEquals("Kanto", result.get(0).getName());
		assertEquals("Johto", result.get(1).getName());
	}

}
