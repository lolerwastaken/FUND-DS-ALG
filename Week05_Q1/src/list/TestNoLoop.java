import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNoLoop {
	@Test
	void testNoLoop() throws FileNotFoundException { // 4 marks
		// You must provide the correct path for your file
		File f = new File("src/list/ShiftableList.java");
		Scanner s = new Scanner(f);

		boolean foundLoop = false;
		String line = "";
		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("shift(DListNode")) {
				break;
			}
		}

		while (s.hasNextLine()) {
			line = s.nextLine();
			if (line.contains("for") || line.contains("while") || line.contains("shift")) {
				foundLoop = true;
				break;
			}
			
		}
		s.close();
		assertFalse(foundLoop);

	}

}
