package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import logic.Station;

public class TestStation {

	private Station t;
	
	@BeforeEach
	void setUp() throws Exception {
		t = new Station("TestStation", 10);
	}
	
	@Test
	public void testConstructor() {
		assertEquals("TestStation", t.getName());
		assertEquals(10, t.getNumber());
		
		t = new Station("TestStation", -1);
		assertEquals(0, t.getNumber());
	}
	
	@Test
	public void testSetName() {
		t.setName("Minmay");
		assertEquals("Minmay", t.getName());

		t.setName("Misa");
		assertEquals("Misa", t.getName());
	}
	
	@Test
	public void testSetNumber() {
		t.setNumber(2);
		assertEquals(2, t.getNumber());
		
		t.setNumber(0);
		assertEquals(0, t.getNumber());
		
		t.setNumber(-1);
		assertEquals(0, t.getNumber());
		
		t.setNumber(-2);
		assertEquals(0, t.getNumber());
	}

	

}
