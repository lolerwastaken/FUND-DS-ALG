package test;

//import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import bst.BST;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBST {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testheight() {
		BST t = new BST(null, 0);
		assertEquals(-1, t.height());

		t.insert(5);
		assertEquals(0, t.height());

		t.insert(8);
		assertEquals(1, t.height());

		t.insert(4);
		assertEquals(1, t.height());

		t.insert(2);
		assertEquals(2, t.height());

		t.insert(6);
		assertEquals(2, t.height());

		t.insert(7);
		assertEquals(3, t.height());

	}

	@Test
	void testheight2() {
		BST t = new BST(null, 0);
		assertEquals(-1, t.height());

		t.insert(4);
		assertEquals(0, t.height());

		t.insert(2);
		assertEquals(1, t.height());

		t.insert(3);
		assertEquals(2, t.height());

		t.insert(6);
		assertEquals(2, t.height());

		t.insert(5);
		assertEquals(2, t.height());

		t.insert(1);
		assertEquals(2, t.height());

		t.insert(7);
		assertEquals(2, t.height());

		t.insert(8);
		assertEquals(3, t.height());

		t.insert(3);
		assertEquals(3, t.height());

	}

	@Test
	void testmakeBalancedTree1() {
		BST t = new BST(null, 0);
		t.makeBalancedTree();
		assertNull(t.root);

	}

	@Test
	void testmakeBalancedTree2() {
		BST t = new BST(null, 0);
		t.insert(0);
		t.insert(1);
		t.insert(2);
		t.makeBalancedTree();
		assertEquals(1, t.root.data);
		assertEquals(0, t.root.left.data);
		assertEquals(2, t.root.right.data);

		// same numbers but different tree shape
		t = new BST(null, 0);
		t.insert(2);
		t.insert(1);
		t.insert(0);
		t.makeBalancedTree();
		assertEquals(1, t.root.data);
		assertEquals(0, t.root.left.data);
		assertEquals(2, t.root.right.data);

	}

	@Test
	void testmakeBalancedTree3() {
		BST t = new BST(null, 0);
		t.insert(5);
		t.insert(4);
		t.insert(2);
		t.insert(1);
		t.insert(3);
		t.makeBalancedTree();
		assertEquals(5, t.size);
		for (int i = 1; i <= 5; i++) {
			assertTrue(t.contains(i));
		}
		assertTrue(t.isBalanced(t.root));

		// same numbers but different tree shape
		t = new BST(null, 0);
		t.insert(5);
		t.insert(4);
		t.insert(3);
		t.insert(2);
		t.insert(1);
		t.makeBalancedTree();
		assertEquals(5, t.size);
		for (int i = 1; i <= 5; i++) {
			assertTrue(t.contains(i));
		}
		assertTrue(t.isBalanced(t.root));

	}

	@Test
	void testmakeBalancedTree4() {
		BST t = new BST(null, 0);
		t.insert(3);
		t.insert(1);
		t.insert(2);
		t.insert(4);
		t.insert(8);
		t.insert(9);
		t.insert(5);
		t.insert(7);
		t.insert(6);
		t.makeBalancedTree();
		assertEquals(9, t.size);
		for (int i = 1; i <= 9; i++) {
			assertTrue(t.contains(i));
		}
		assertTrue(t.isBalanced(t.root));

		// same numbers but different tree shape
		t = new BST(null, 0);
		t.insert(7);
		t.insert(6);
		t.insert(9);
		t.insert(2);
		t.insert(8);
		t.insert(1);
		t.insert(4);
		t.insert(3);
		t.insert(5);
		t.makeBalancedTree();
		assertEquals(9, t.size);
		for (int i = 1; i <= 9; i++) {
			assertTrue(t.contains(i));
		}
		assertTrue(t.isBalanced(t.root));

	}

}
