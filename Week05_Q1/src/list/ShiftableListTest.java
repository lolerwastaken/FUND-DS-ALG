import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShiftableListTest {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testShiftSimple01() throws Exception {  //1 mark
		ShiftableList l = new ShiftableList("xyz");
		DListNode newStart = l.header.previousNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('z',itr.next());
		assertEquals('x',itr.next());
		assertEquals('y',itr.next());
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('y', itr.currentNode.data);
		itr.previous();
		assertEquals('x', itr.currentNode.data);
		itr.previous();
		assertEquals('z', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		
		
		
	}
	
	@Test
	void testShiftSimple02() throws Exception {  //1 mark
		ShiftableList l = new ShiftableList("xyz");
		DListNode newStart = l.header.nextNode.nextNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('y',itr.next());
		assertEquals('z',itr.next());
		assertEquals('x',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('x', itr.currentNode.data);
		itr.previous();
		assertEquals('z', itr.currentNode.data);
		itr.previous();
		assertEquals('y', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		
		
	}


	@Test
	void testShift1() throws Exception {  //2 marks
		ShiftableList l = new ShiftableList("abcd");
		DListNode newStart = l.header.previousNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('d',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		

	}
	
	@Test
	void testShift2() throws Exception { //2 marks
		ShiftableList l = new ShiftableList("abcde");
		DListNode newStart = l.header.previousNode.previousNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('d',itr.next());
		assertEquals('e',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		

	}
	
	@Test
	void testShift3() throws Exception { //2 marks
		ShiftableList l = new ShiftableList("abcdefg");
		DListNode newStart = l.header.nextNode.nextNode.nextNode.nextNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('d',itr.next());
		assertEquals('e',itr.next());
		assertEquals('f',itr.next());
		assertEquals('g',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('g', itr.currentNode.data);
		itr.previous();
		assertEquals('f', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		
	}

	@Test
	void testShift4() throws Exception { //2 mark
		ShiftableList l = new ShiftableList("abcdefgh");
		DListNode newStart = l.header.nextNode.nextNode;
		int originalSize = l.size();
		l.shift(newStart);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		assertEquals('d',itr.next());
		assertEquals('e',itr.next());
		assertEquals('f',itr.next());
		assertEquals('g',itr.next());
		assertEquals('h',itr.next());
		assertEquals('a',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('h', itr.currentNode.data);
		itr.previous();
		assertEquals('g', itr.currentNode.data);
		itr.previous();
		assertEquals('f', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		
	}

	
	
	////////////////////////////
	@Test
	void testShiftN1() throws Exception { //1 mark
		ShiftableList l = new ShiftableList("abcde");
		int originalSize = l.size();
		l.shift(5);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('e',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		assertEquals('d',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		
		
	}
	
	@Test
	void testShiftN2() throws Exception { //1 marks
		ShiftableList l = new ShiftableList("abcdef");
		int originalSize = l.size();
		l.shift(5);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
	
		assertEquals('e',itr.next());
		assertEquals('f',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		assertEquals('d',itr.next());

		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('f', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);

		
	}

	@Test
	void testShiftN3() throws Exception { //1 marks
		ShiftableList l = new ShiftableList("abcdefghi");
		int originalSize = l.size();
		l.shift(5);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('e',itr.next());
		assertEquals('f',itr.next());
		assertEquals('g',itr.next());
		assertEquals('h',itr.next());
		assertEquals('i',itr.next());
		assertEquals('a',itr.next());
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		assertEquals('d',itr.next());
		
		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('i', itr.currentNode.data);
		itr.previous();
		assertEquals('h', itr.currentNode.data);
		itr.previous();
		assertEquals('g', itr.currentNode.data);
		itr.previous();
		assertEquals('f', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		

	}
	
	@Test
	void testShiftN4() throws Exception { //1 marks
		ShiftableList l = new ShiftableList("abcdefgh");
		int originalSize = l.size();
		l.shift(2);
		
		DListIterator itr = new DListIterator(l.header);
		int size = l.size();
		
		assertEquals(originalSize,size);
		assertEquals('b',itr.next());
		assertEquals('c',itr.next());
		assertEquals('d',itr.next());
		assertEquals('e',itr.next());
		assertEquals('f',itr.next());
		assertEquals('g',itr.next());
		assertEquals('h',itr.next());
		assertEquals('a',itr.next());

		itr.next();
		assertEquals(l.header, itr.currentNode);
		itr.previous();
		assertEquals('a', itr.currentNode.data);
		itr.previous();
		assertEquals('h', itr.currentNode.data);
		itr.previous();
		assertEquals('g', itr.currentNode.data);
		itr.previous();
		assertEquals('f', itr.currentNode.data);
		itr.previous();
		assertEquals('e', itr.currentNode.data);
		itr.previous();
		assertEquals('d', itr.currentNode.data);
		itr.previous();
		assertEquals('c', itr.currentNode.data);
		itr.previous();
		assertEquals('b', itr.currentNode.data);
		itr.previous();
		assertEquals(l.header, itr.currentNode);
		

	}

}
