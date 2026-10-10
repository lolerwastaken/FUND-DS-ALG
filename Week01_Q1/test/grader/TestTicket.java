package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import logic.Station;
import logic.Ticket;

public class TestTicket {

	private Ticket t;
	private Station start;
	private Station end;

	@BeforeEach
	void setUp() throws Exception {
		start = new Station("A", 0);
		end = new Station("B", 8);
		t = new Ticket(0, start, end);
	}

	@Test
	public void testSetTypeLegal() {

		t.setType(0);
		assertEquals(0, t.getType());
		assertEquals(30, t.getPricePerStation());

		t.setType(1);
		assertEquals(1, t.getType());
		assertEquals(30, t.getPricePerStation());

		t.setType(2);
		assertEquals(2, t.getType());
		assertEquals(25, t.getPricePerStation());

	}

	@Test
	public void testSetTypeIllegal() {
		t.setType(-1);
		assertEquals(1, t.getType());
		assertEquals(30, t.getPricePerStation());

		t.setType(3);
		assertEquals(1, t.getType());
		assertEquals(30, t.getPricePerStation());
	}

	@Test
	public void testSetStation() {
		t.setStation(start, end);
		assertEquals(start, t.getStart());
		assertEquals(end, t.getEnd());
	}

	@Test
	public void testCalculatePrice() {
		t.setStation(start, end);
		assertEquals(192, t.calculatePrice());

		t.setType(1);
		assertEquals(240, t.calculatePrice());

		t.setType(2);
		assertEquals(-1, t.calculatePrice());

		end = new Station("C", 4);
		t.setType(0);
		t.setStation(start, end);
		assertEquals(120, t.calculatePrice());

		t.setType(2);
		assertEquals(60, t.calculatePrice());
		
		t.setStation(start, start);
		assertEquals(-1, t.calculatePrice());
		
		Station end2 = new Station("A",9);
		t.setStation(start, end2);
		assertEquals(-1, t.calculatePrice());
		
	}

	@Test
	public void testGetDescription() {
		t.setStation(start, end);
		assertEquals("Student Ticket, from A to B", t.getDescription());
		
		t.setType(1);
		t.setStation(end,start);
		assertEquals("Adult Ticket, from B to A", t.getDescription());
		
		t.setType(2);
		t.setStation(end,start);
		assertEquals("Invalid Ticket, from B to A", t.getDescription());
		
		end = new Station("C", 6);
		t.setType(2);
		t.setStation(start,end);
		assertEquals("Elderly Ticket, from A to C", t.getDescription());
		
		end = new Station("C", 7);
		t.setType(2);
		t.setStation(start,end);
		assertEquals("Invalid Ticket, from A to C", t.getDescription());
		
	}

}
