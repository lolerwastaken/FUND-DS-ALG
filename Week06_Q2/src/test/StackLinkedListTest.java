package test;

import static org.junit.jupiter.api.Assertions.*;

import linkedlist.CDLinkedList;
import linkedlist.DListIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import stack.StackLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class StackLinkedListTest {

	StackLinkedList singleL;
	StackLinkedList multiL;

	@BeforeEach
	void setUp() throws Exception {
		singleL = new StackLinkedList();
		singleL.push(1);

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
		singleL.removeRange(0, 0);
		assertTrue(singleL.isEmpty());
	}

	@Test
	void testRemoveRangeFirstSingle() throws Exception {
		multiL.removeRange(0, 0);
		CDLinkedList list = multiL.getTheList();
		assertEquals(5, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(50, itr.next());
		assertEquals(40, itr.next());
		assertEquals(30, itr.next());
		assertEquals(20, itr.next());
		assertEquals(10, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(10, itr2.previous());
		assertEquals(20, itr2.previous());
		assertEquals(30, itr2.previous());
		assertEquals(40, itr2.previous());
		assertEquals(50, itr2.previous());

		int n = 50;
		int count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(5, count);
	}

	@Test
	void testRemoveRangeFirstFew() throws Exception {
		multiL.removeRange(0, 1);
		CDLinkedList list = multiL.getTheList();
		assertEquals(4, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(40, itr.next());
		assertEquals(30, itr.next());
		assertEquals(20, itr.next());
		assertEquals(10, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(10, itr2.previous());
		assertEquals(20, itr2.previous());
		assertEquals(30, itr2.previous());
		assertEquals(40, itr2.previous());

		int n = 40;
		int count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(4, count);

	}

	@Test
	void testRemoveRangeLastSingle() throws Exception {
		multiL.removeRange(5, 5);
		CDLinkedList list = multiL.getTheList();
		assertEquals(5, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(60, itr.next());
		assertEquals(50, itr.next());
		assertEquals(40, itr.next());
		assertEquals(30, itr.next());
		assertEquals(20, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(20, itr2.previous());
		assertEquals(30, itr2.previous());
		assertEquals(40, itr2.previous());
		assertEquals(50, itr2.previous());
		assertEquals(60, itr2.previous());

		int n = 60;
		int count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(5, count);
	}

	@Test
	void testRemoveRangeLastFew() throws Exception {
		multiL.removeRange(2, 5);
		CDLinkedList list = multiL.getTheList();
		assertEquals(2, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(60, itr.next());
		assertEquals(50, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(50, itr2.previous());
		assertEquals(60, itr2.previous());

		int n = 60;
		int count = 0;
		while (!multiL.isEmpty()) {
			int top = multiL.top();
			assertEquals(n, top);
			multiL.pop();
			n -= 10;
			count++;
		}
		assertEquals(2, count);
	}

	@Test
	void testRemoveRangeMiddleSingle() throws Exception {
		multiL.removeRange(2, 2);
		CDLinkedList list = multiL.getTheList();
		assertEquals(5, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(60, itr.next());
		assertEquals(50, itr.next());
		assertEquals(30, itr.next());
		assertEquals(20, itr.next());
		assertEquals(10, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(10, itr2.previous());
		assertEquals(20, itr2.previous());
		assertEquals(30, itr2.previous());
		assertEquals(50, itr2.previous());
		assertEquals(60, itr2.previous());

		int top = multiL.top();
		assertEquals(60, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(50, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(30, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(20, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(10, top);
		multiL.pop();

		assertTrue(multiL.isEmpty());
	}

	@Test
	void testRemoveRangeMiddleFew() throws Exception {
		multiL.removeRange(1, 3);
		CDLinkedList list = multiL.getTheList();
		assertEquals(3, list.size);
		DListIterator itr = new DListIterator(list.header);
		assertEquals(60, itr.next());
		assertEquals(20, itr.next());
		assertEquals(10, itr.next());
		DListIterator itr2 = new DListIterator(list.header.previousNode);
		assertEquals(10, itr2.previous());
		assertEquals(20, itr2.previous());
		assertEquals(60, itr2.previous());

		int top = multiL.top();
		assertEquals(60, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(20, top);
		multiL.pop();

		top = multiL.top();
		assertEquals(10, top);
		multiL.pop();

		assertTrue(multiL.isEmpty());

	}

	@Test
	void testNoForbiddenMethod() throws FileNotFoundException { // 4 marks
		// You must provide the correct path for your file
		File f = new File("src/stack/StackLinkedList.java");
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
