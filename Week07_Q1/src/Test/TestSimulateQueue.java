package Test;

import static org.junit.jupiter.api.Assertions.*;

import Queue.MyQueue;
import Queue.QueueArray;
import Queue.QueueLinkedList;
import Simulation.CustomerInfo;
import Simulation.SimulateQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSimulateQueue {

	CustomerInfo[][] allEvents1;
	MyQueue[] allQueues1;

	CustomerInfo[][] allEvents2;
	MyQueue[] allQueues2;

	void initializeFirstSample() {
		// initialize first events and queues example
		allQueues1 = new MyQueue[3];
		allQueues1[0] = new QueueLinkedList();
		allQueues1[1] = new QueueArray();
		allQueues1[2] = new QueueLinkedList();

		allEvents1 = new CustomerInfo[3][];
		allEvents1[0] = new CustomerInfo[6];
		allEvents1[1] = new CustomerInfo[4];
		allEvents1[2] = new CustomerInfo[5];

		allEvents1[0][0] = new CustomerInfo(0, 1);
		allEvents1[0][1] = new CustomerInfo(1, 1);
		allEvents1[0][2] = new CustomerInfo(2, -1);
		allEvents1[0][3] = new CustomerInfo(5, 1);
		allEvents1[0][4] = new CustomerInfo(8, -1);
		allEvents1[0][5] = new CustomerInfo(9, 1);

		allEvents1[1][0] = new CustomerInfo(0, 1);
		allEvents1[1][1] = new CustomerInfo(4, 1);
		allEvents1[1][2] = new CustomerInfo(6, 1);
		allEvents1[1][3] = new CustomerInfo(8, -1);

		allEvents1[2][0] = new CustomerInfo(1, 1);
		allEvents1[2][1] = new CustomerInfo(3, -1);
		allEvents1[2][2] = new CustomerInfo(4, 1);
		allEvents1[2][3] = new CustomerInfo(5, 1);
		allEvents1[2][4] = new CustomerInfo(9, -1);

	}
	
	void initializeSecondSample() {
		// initialize first events and queues example
		allQueues2 = new MyQueue[3];
		allQueues2[0] = new QueueLinkedList();
		allQueues2[1] = new QueueLinkedList();
		allQueues2[2] = new QueueArray();

		allEvents2 = new CustomerInfo[3][];
		allEvents2[0] = new CustomerInfo[4];
		allEvents2[1] = new CustomerInfo[5];
		allEvents2[2] = new CustomerInfo[4];

		allEvents2[0][0] = new CustomerInfo(0, 1);
		allEvents2[0][1] = new CustomerInfo(1, 1);
		allEvents2[0][2] = new CustomerInfo(7, 1);	
		allEvents2[0][3] = new CustomerInfo(10, -1);
	

		allEvents2[1][0] = new CustomerInfo(1, 1);
		allEvents2[1][1] = new CustomerInfo(2, 1);
		allEvents2[1][2] = new CustomerInfo(4, -1);
		allEvents2[1][3] = new CustomerInfo(5, 1);
		allEvents2[1][4] = new CustomerInfo(8, 1);

		allEvents2[2][0] = new CustomerInfo(0, 1);
		allEvents2[2][1] = new CustomerInfo(3, 1);
		allEvents2[2][2] = new CustomerInfo(6, 1);
		allEvents2[2][3] = new CustomerInfo(11, -1);
		

	}

	@BeforeEach
	void setUp() throws Exception {
         initializeFirstSample();
         initializeSecondSample();
	}

	@Test
	void testFirstSampleEarly() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents1, allQueues1);
		s.stateBeforeTimeT(3);
		assertEquals(1, s.allQueues[0].size());
		assertEquals(1, s.allQueues[1].size());
		assertEquals(1, s.allQueues[2].size());

	}

	@Test
	void testFirstSampleLate1() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents1, allQueues1);
		s.stateBeforeTimeT(7);
		assertEquals(2, s.allQueues[0].size());
		assertEquals(3, s.allQueues[1].size());
		assertEquals(2, s.allQueues[2].size());
	}
	
	@Test
	void testFirstSampleLate2() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents1, allQueues1);
		s.stateBeforeTimeT(9);
		assertEquals(1, s.allQueues[0].size());
		assertEquals(2, s.allQueues[1].size());
		assertEquals(2, s.allQueues[2].size());

	}
	
	@Test
	void testSecondSampleEarly() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents2, allQueues2);
		s.stateBeforeTimeT(5);
		assertEquals(2, s.allQueues[0].size());
		assertEquals(1, s.allQueues[1].size());
		assertEquals(2, s.allQueues[2].size());
		
	}
	
	@Test
	void testSecondSampleMid() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents2, allQueues2);
		s.stateBeforeTimeT(9);
		assertEquals(3, s.allQueues[0].size());
		assertEquals(3, s.allQueues[1].size());
		assertEquals(3, s.allQueues[2].size());
		
	}
	
	@Test
	void testSecondSampleLate() throws Exception {
		SimulateQueue s = new SimulateQueue(allEvents2, allQueues2);
		s.stateBeforeTimeT(12);
		assertEquals(2, s.allQueues[0].size());
		assertEquals(3, s.allQueues[1].size());
		assertEquals(2, s.allQueues[2].size());
		
	}
	
	
	

}
