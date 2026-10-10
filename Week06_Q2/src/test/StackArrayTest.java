package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.StackArray;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class StackArrayTest {
	StackArray singleA;
	StackArray multiA;

	@BeforeEach
	void setUp() throws Exception {
		singleA = new StackArray();
		singleA.push(0);

		multiA = new StackArray();
		multiA.push(35);
		multiA.push(30);
		multiA.push(25);
		multiA.push(20);
		multiA.push(15);
		multiA.push(10);
		multiA.push(5);

	}

	@Test
	void testRemoveRangeSingleItem() throws Exception {
		singleA.removeRange(0, 0);
		assertTrue(singleA.isEmpty());
	}

	@Test
	void testRemoveRangeFirstSingle() throws Exception {
		multiA.removeRange(0, 0);
		assertEquals(6,multiA.getCurrentSize()); 
		assertEquals(10,multiA.getTheArray()[5]); 
		assertEquals(15,multiA.getTheArray()[4]);
		assertEquals(20,multiA.getTheArray()[3]);
		assertEquals(25,multiA.getTheArray()[2]);
		assertEquals(30,multiA.getTheArray()[1]);
		assertEquals(35,multiA.getTheArray()[0]);
		
		int n = 10;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(6, count);
	}

	@Test
	void testRemoveRangeFirstFew() throws Exception {
		multiA.removeRange(0, 3);
		assertEquals(3,multiA.getCurrentSize()); 
		assertEquals(25,multiA.getTheArray()[2]);
		assertEquals(30,multiA.getTheArray()[1]);
		assertEquals(35,multiA.getTheArray()[0]);
		
		int n = 25;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(3, count);
	}

	@Test
	void testRemoveRangeLastSingle() throws Exception {
		multiA.removeRange(6, 6);
		assertEquals(6,multiA.getCurrentSize());
		assertEquals(5,multiA.getTheArray()[5]); 
		assertEquals(10,multiA.getTheArray()[4]); 
		assertEquals(15,multiA.getTheArray()[3]);
		assertEquals(20,multiA.getTheArray()[2]);
		assertEquals(25,multiA.getTheArray()[1]);
		assertEquals(30,multiA.getTheArray()[0]);
		
		int n = 5;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(6, count);

	}

	@Test
	void testRemoveRangeLastFew() throws Exception {
		multiA.removeRange(4, 6);
		assertEquals(4,multiA.getCurrentSize());
		assertEquals(5,multiA.getTheArray()[3]); 
		assertEquals(10,multiA.getTheArray()[2]); 
		assertEquals(15,multiA.getTheArray()[1]);
		assertEquals(20,multiA.getTheArray()[0]);
		
		int n = 5;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(4, count);
	}

	@Test
	void testRemoveRangeMiddleSingle() throws Exception {
		multiA.removeRange(4, 4);
		assertEquals(6,multiA.getCurrentSize());
		assertEquals(5,multiA.getTheArray()[5]); 
		assertEquals(10,multiA.getTheArray()[4]); 
		assertEquals(15,multiA.getTheArray()[3]);
		assertEquals(20,multiA.getTheArray()[2]);
		assertEquals(30,multiA.getTheArray()[1]);
		assertEquals(35,multiA.getTheArray()[0]);
		
		int top = multiA.top();
		assertEquals(5, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(10, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(15, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(20, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(30, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(35, top);
		multiA.pop();

		assertTrue(multiA.isEmpty());

		
	}

	@Test
	void testRemoveRangeMiddleFew() throws Exception {
		multiA.removeRange(2, 4);
		assertEquals(4,multiA.getCurrentSize());
		assertEquals(5,multiA.getTheArray()[3]); 
		assertEquals(10,multiA.getTheArray()[2]); 
		assertEquals(30,multiA.getTheArray()[1]);
		assertEquals(35,multiA.getTheArray()[0]);
		
		int top = multiA.top();
		assertEquals(5, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(10, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(30, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(35, top);
		multiA.pop();
		assertTrue(multiA.isEmpty());


	}

	@Test
	void testNoForbiddenMethod() throws FileNotFoundException { // 4 marks
		// You must provide the correct path for your file
		File f = new File("src/stack/StackArray.java");
		Scanner s = new Scanner(f);

		boolean foundForbidden = false;
		String line = "";
		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("removeRange(int")) {
				break;
			}
		}

		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("pop(") || line.contains("top(") || line.contains("push(") || line.contains("makeEmpty(")
			|| line.contains("findKth(") || line.contains("insert(") || line.contains("find(")
					|| line.contains("findPrevious(") || line.contains("remove(")
					|| line.contains("removeAt(") || line.contains("printList(")
					|| line.contains("getTheArray(")) {
				foundForbidden = true;
				break;
			}

		}
		s.close();
		assertFalse(foundForbidden);

	}

}
