package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.Player;
import logic.Quest;
import logic.Region;
import logic.Status;

class RegionTest {
	
	Region r;
	Player p1, p2, p3;
	
	@BeforeEach
	void setUp(){
		r = new Region("Sinnoh");
		
		//Populate with datas
		p1 = new Player("Barry");
		p1.setScore(6000);
		
		p2 = new Player("Cynthia");
		p2.setScore(25000);
		
		p3 = new Player("Looker");
		p3.setScore(15000);
		
		ArrayList<Player> pList = new ArrayList<Player>();
		pList.add(p1);
		pList.add(p2);
		pList.add(p3);
		
		r.setPlayerList(pList);
		
		Quest q1 = new Quest(p2, r, "Quest 1", "d1");
		q1.setStatus(Status.FINISHED);
		
		Quest q2 = new Quest(p2, r, "Quest 2", "d2");
		q2.setStatus(Status.ACTIVE);
		p1.setCurrentQuest(q2);
		
		Quest q3 = new Quest(p3, r, "Quest 3", "d3");
		q3.setStatus(Status.AVAILABLE);
		
		Quest q4 = new Quest(p2, r, "Quest 4", "d4");
		q4.setStatus(Status.AVAILABLE);
		
		ArrayList<Quest> qList = new ArrayList<Quest>();
		qList.add(q1);
		qList.add(q2);
		qList.add(q3);
		qList.add(q4);
		
		r.setQuestList(qList);
	}
	
	@Test
	void testConstructor() {
		r = new Region("Hoenn");
		assertEquals("Hoenn",r.getName());
		assertEquals(0,r.getPlayerList().size());
		assertEquals(0,r.getQuestList().size());
	}
	
	@Test
	void testConstructorEmpty() {
		r = new Region(" ");
		assertEquals("Nowhere",r.getName());
		assertEquals(0,r.getPlayerList().size());
		assertEquals(0,r.getQuestList().size());
	}


	@Test
	void testSetName() {
		r.setName("Kanto");
		assertEquals("Kanto",r.getName());
	}
	
	@Test
	void testSetNameEmpty() {
		r.setName("  ");
		assertEquals("Nowhere",r.getName());
	}

	@Test
	void testAddPlayerToRegion() {
		Player p4 = new Player("Cyrus");
		r.addPlayerToRegion(p4);
		
		assertEquals(4,r.getPlayerList().size());
		Player pInList = r.getPlayerList().get(3);
		assertEquals("Cyrus", pInList.getName());
		assertEquals(0, pInList.getScore());
		assertNull(pInList.getCurrentQuest());
		
		Player p5 = new Player("Cheryl");
		r.addPlayerToRegion(p5);
		
		assertEquals(5,r.getPlayerList().size());
		Player pInList2 = r.getPlayerList().get(4);
		assertEquals("Cheryl", pInList2.getName());
		assertEquals(0, pInList2.getScore());
		assertNull(pInList2.getCurrentQuest());
	}

	@Test
	void testAddQuestToRegion() {
		Quest q = new Quest(new Player("Roark"), r, "New Quest", "d5");
		r.addQuestToRegion(q);
		
		assertEquals(5,r.getQuestList().size());
		Quest newQuest = r.getQuestList().get(4);
		assertEquals("Roark", newQuest.getAuthor().getName());
		assertEquals("New Quest", newQuest.getName());
		assertEquals("Sinnoh", newQuest.getRegion().getName());
		assertEquals("d5", newQuest.getDescription());
		
		Quest q2 = new Quest(new Player("Gardenia"), r, "New Quest 2", "d6");
		r.addQuestToRegion(q2);
		
		assertEquals(6,r.getQuestList().size());
		Quest newQuest2 = r.getQuestList().get(5);
		assertEquals("Gardenia", newQuest2.getAuthor().getName());
		assertEquals("New Quest 2", newQuest2.getName());
		assertEquals("Sinnoh", newQuest2.getRegion().getName());
		assertEquals("d6", newQuest2.getDescription());
		
	}
	
	@Test
	void testGetPlayerCount() {
		assertEquals(3,r.getPlayerCount());
	}

	@Test
	void testGetRegionRank() {
		assertEquals(3.33,r.getRegionRank());
	}

	@Test
	void testGetAvailableQuests() {
		assertEquals(2,r.getAvailableQuests(p1).size()); //Two available quests for p1
		assertEquals(1,r.getAvailableQuests(p3).size()); //p3 cannot see their own quest
		
		Quest q = r.getAvailableQuests(p1).get(0);
		assertEquals("Looker",q.getAuthor().getName());
		assertEquals("Sinnoh",q.getRegion().getName());
		assertEquals("Quest 3",q.getName());
		assertEquals("d3",q.getDescription());
		
		q = r.getAvailableQuests(p1).get(1);
		assertEquals("Cynthia",q.getAuthor().getName());
		assertEquals("Sinnoh",q.getRegion().getName());
		assertEquals("Quest 4",q.getName());
		assertEquals("d4",q.getDescription());
		
		q = r.getAvailableQuests(p3).get(0);
		assertEquals("Cynthia",q.getAuthor().getName());
		assertEquals("Sinnoh",q.getRegion().getName());
		assertEquals("Quest 4",q.getName());
		assertEquals("d4",q.getDescription());
		
	}

}
