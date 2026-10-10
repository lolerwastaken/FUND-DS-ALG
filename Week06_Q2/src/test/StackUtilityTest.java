package test;

import static org.junit.jupiter.api.Assertions.*;

import myInterface.MyStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.StackArray;
import stack.StackLinkedList;
import stack.StackUtility;

class StackUtilityTest {
	StackArray singleA;
	StackLinkedList singleL;
	StackArray multiA;
	StackLinkedList multiL;

	@BeforeEach
	void setUp() throws Exception {
		singleA = new StackArray();
		singleA.push(0);

		singleL = new StackLinkedList();
		singleL.push(1);

		multiA = new StackArray();
		multiA.push(35);
		multiA.push(30);
		multiA.push(25);
		multiA.push(20);
		multiA.push(15);
		multiA.push(10);
		multiA.push(5);

		multiL = new StackLinkedList();
		multiL.push(10);
		multiL.push(20);
		multiL.push(30);
		multiL.push(40);
		multiL.push(50);
		multiL.push(60);

	}

	@Test
	void testRemoveRangeSingleItem() throws Exception {
		MyStack ans = StackUtility.removeRange(singleA, 0, 0);
		assertTrue(ans.isEmpty());
		assertTrue(singleA.isEmpty());

		ans = StackUtility.removeRange(singleL, 0, 0);
		assertTrue(ans.isEmpty());
		assertTrue(singleL.isEmpty());
	}

	@Test
	void testRemoveRangeFirstSingle() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 0, 0);
		int n = 10;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(multiA.top(), ans.top());
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(6, count);

		ans = StackUtility.removeRange(multiL, 0, 0);
		n = 50;
		count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(multiL.top(), ans.top());
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(5, count);
	}

	@Test
	void testRemoveRangeFirstFew() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 0, 3);
		int n = 25;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(multiA.top(), ans.top());
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(3, count);

		ans = StackUtility.removeRange(multiL, 0, 1);
		n = 40;
		count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(multiL.top(), ans.top());
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(4, count);

	}

	@Test
	void testRemoveRangeLastSingle() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 6, 6);
		int n = 5;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(multiA.top(), ans.top());
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(6, count);

		ans = StackUtility.removeRange(multiL, 5, 5);
		n = 60;
		count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(multiL.top(), ans.top());
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(5, count);
	}

	@Test
	void testRemoveRangeLastFew() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 4, 6);
		int n = 5;
		int count = 0;
		while (!multiA.isEmpty()) {
			int top = multiA.top();
			assertEquals(multiA.top(), ans.top());
			assertEquals(n, top);
			multiA.pop();
			n += 5;
			count++;
		}
		assertEquals(4, count);

		ans = StackUtility.removeRange(multiL, 2, 5);
		n = 60;
		count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(multiL.top(), ans.top());
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(2, count);
	}

	@Test
	void testRemoveRangeMiddleSingle() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 4, 4);

		int top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(5, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(10, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(15, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(20, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(30, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(35, top);
		multiA.pop();

		assertTrue(multiA.isEmpty());

		ans = StackUtility.removeRange(multiL, 2, 2);

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(60, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(50, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(30, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(20, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(10, top);
		multiL.pop();

		assertTrue(multiL.isEmpty());
	}

	@Test
	void testRemoveRangeMiddleFew() throws Exception {
		MyStack ans = StackUtility.removeRange(multiA, 2, 4);

		int top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(5, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(10, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(30, top);
		multiA.pop();

		top = multiA.top();
		assertEquals(top, ans.top());
		assertEquals(35, top);
		multiA.pop();
		assertTrue(multiA.isEmpty());

		ans = StackUtility.removeRange(multiL, 1, 3);

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(60, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(20, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(top, ans.top());
		assertEquals(10, top);
		multiL.pop();
		
		assertTrue(multiL.isEmpty());

	}

}
