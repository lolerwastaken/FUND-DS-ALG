import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBigO {
	Random r = new Random();
	int[] longArray = new int[10000];
	int[] longArrayWithDup = new int[100000];
	int[] testSum = new int[100];

	long startTime;
	boolean result;;
	long endTime;
	long badTime;
	long goodTime;
	List<List<Integer>> resultList;

	@BeforeEach
	void setUp() throws Exception {

		for (int i = 0; i < 10000; i++) {
			longArray[i] = i;
		}

		for (int i = 0; i < 100000; i++) {
			longArrayWithDup[i] = i;
		}
		longArrayWithDup[50000] = 60000;

		for (int i = 0; i < 100; i++) {
			testSum[i] = r.nextInt(1, 25);
			if (r.nextBoolean()) {
				testSum[i] *= (-1);
			}
		}

		startTime = 0;
		result = false;
		;
		endTime = 0;
		badTime = 0;
		goodTime = 0;
		resultList = new ArrayList<List<Integer>>();

	}

	void calculatem1Version1(int[] a) {
		startTime = System.nanoTime();
		result = BigO.m1(a);
		endTime = System.nanoTime();
		badTime = endTime - startTime;
	}

	void calculatem1Version2(int[] a) {
		startTime = System.nanoTime();
		result = BigO.m1Version2(a);
		endTime = System.nanoTime();
		goodTime = endTime - startTime;
	}

	List<List<Integer>> calculatem2Version1(int[] a) {
		startTime = System.nanoTime();
		resultList = BigO.m2(a);
		endTime = System.nanoTime();
		badTime = endTime - startTime;
		return resultList;
	}
	
	List<List<Integer>> calculatem2Version2(int[] a) {
		startTime = System.nanoTime();
		resultList = BigO.m2Version2(a);
		endTime = System.nanoTime();
		goodTime = endTime - startTime;
		return resultList;
	}


	@Test
	void testM1_longArray_NoDup() {

		calculatem1Version1(longArray);
		assertFalse(result);
		System.out.println("Long Array (no duplicates): Bad Implementation Time taken: " + badTime + " nanoseconds");

		calculatem1Version2(longArray);
		assertFalse(result);

		System.out.println("Long Array (no duplicates): Good Implementation Time taken: " + goodTime + " nanoseconds");
		assertTrue(goodTime * 4 < badTime);

	}

	@Test
	void testM1_longArray_Dup() {
		calculatem1Version1(longArrayWithDup);
		assertTrue(result);
		System.out.println("Long Array: Bad Implementation Time taken: " + badTime + " nanoseconds");

		calculatem1Version2(longArrayWithDup);
		assertTrue(result);

		System.out.println("Long Array: Good Implementation Time taken: " + goodTime + " nanoseconds");
		assertTrue(goodTime * 10 < badTime);

	}

	@Test
	void testM2() {

		List<List<Integer>> r1 = calculatem2Version1(testSum);
		List<List<Integer>> r2 = calculatem2Version2(testSum);
	    assertEquals(r1.size(),r2.size());
	    
	    System.out.println("sum check: Bad Implementation Time taken: " + badTime + " nanoseconds");
	    System.out.println("sum check: Good Implementation Time taken: " + goodTime + " nanoseconds");
		assertTrue(goodTime*2  < badTime);
		
		if(r1.size() >0) {
			for(int i =0; i<r1.size();i++) {
				assertTrue(r2.contains(r1.get(i)));
				assertTrue(r1.contains(r2.get(i)));	
			}
		}

	}

}
