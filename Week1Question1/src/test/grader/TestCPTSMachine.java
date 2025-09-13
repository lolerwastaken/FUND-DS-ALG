package test.grader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.CPTSMachine;
import logic.Station;

class TestCPTSMachine {
	private Station start;
	private Station end;

	@BeforeEach
	void setUp() throws Exception {
		// start = new Station("A",0);
		// end = new Station("B",8);
		CPTSMachine.initializeData();
	}

	@Test
	void testIsStationExisted() {
		assertEquals(true, CPTSMachine.isStationExisted("Siam"));
		assertEquals(false, CPTSMachine.isStationExisted("AAA"));
	}

	@Test
	void testAddStation() {
		assertEquals(7, CPTSMachine.getTotalStationNumber());

		assertEquals(true, CPTSMachine.addStation("AAA"));
		assertEquals(8, CPTSMachine.getTotalStationNumber());

		assertEquals(false, CPTSMachine.addStation("AAA"));
		assertEquals(8, CPTSMachine.getTotalStationNumber());

		assertEquals(false, CPTSMachine.addStation("Thong Lor"));
		assertEquals(8, CPTSMachine.getTotalStationNumber());

	}

	@Test
	void testBuyTicketIllegal() {
		Station start = CPTSMachine.getStationlist().get(0);
		Station end = null;
		assertEquals(false, CPTSMachine.buyTicket(0, start, end));

		start = null;
		end = CPTSMachine.getStationlist().get(4);
		assertEquals(false, CPTSMachine.buyTicket(1, start, end));

		start = CPTSMachine.getStationlist().get(0);
		end = CPTSMachine.getStationlist().get(7);
		assertEquals(false, CPTSMachine.buyTicket(-1, start, end));
		assertEquals(false, CPTSMachine.buyTicket(3, start, end));
		assertEquals(false, CPTSMachine.buyTicket(2, start, end));
		assertEquals(false, CPTSMachine.buyTicket(0, start, start));

	}

	@Test
	void testBuyTicketLegal() {
		start = CPTSMachine.getStationlist().get(0);
		end = CPTSMachine.getStationlist().get(6);
		assertEquals(true, CPTSMachine.buyTicket(0, start, end));
		assertEquals(true, CPTSMachine.buyTicket(1, start, end));
		assertEquals(true, CPTSMachine.buyTicket(2, start, end));
		
		end = CPTSMachine.getStationlist().get(5);
		assertEquals(true, CPTSMachine.buyTicket(0, start, end));
		assertEquals(true, CPTSMachine.buyTicket(1, start, end));
		assertEquals(true, CPTSMachine.buyTicket(2, start, end));
		
		
		
	}

}
