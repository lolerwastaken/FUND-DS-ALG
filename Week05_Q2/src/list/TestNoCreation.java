import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNoCreation {
	@Test
	void testNoCreation() throws FileNotFoundException { // 4 marks
		// You must provide the correct path for your file
		File f = new File("src/list/CDLinkedList.java");
		Scanner s = new Scanner(f);

		boolean foundLoop = false;
		String line = "";
		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("swapRange(Iter")) {
				break;
			}
		}

		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("new DListNode") || line.contains("new CDLinkedList") || line.contains("new ArrayList") || line.contains("new int[") || line.contains("new Queue")) {
				foundLoop = true;
				break;
			}
			
		}
		s.close();
		assertFalse(foundLoop);

	}

}
