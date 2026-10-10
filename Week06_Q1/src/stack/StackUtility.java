package stack;

import myInterface.MyStack;

public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		StackArray s3 = new StackArray(); // temp stack

        // s1 must contain at least 2 elements so that
        // they can be computed with the operator from s2 (cannot be an empty stack)
		while (s1.size() >= 2 && !s2.isEmpty()) {
			int v1 = s1.top(); // Get the top value of s1
			s1.pop(); // Pop v1 (first value)

			int v2 = s1.top(); // Get the other top value of s1, after v1 is popped
			s1.pop(); // Pop v2 (second value)

			int operator = s2.top(); // Get the top value of s2
			s2.pop(); // Pop operator value of s2

			if (operator >= 0) { // Operator value is positive (+)
				s3.push(v1+v2); // Perform add computation and push value into the new stack
			} else { // Operator value is negative (-)
				s3.push(v1-v2); // Perform subtract computation and push value into the new stack
			}
		}

		String messageResult = ""; // Create empty string

		while (!s3.isEmpty()) { // Loop through every element of the s3 stack going from top to bottom
			int letterValue = s3.top(); // Get the top value of the new stack
			s3.pop(); // Pop the letter value
			messageResult += alphabets.charAt(letterValue); // Add resulted letter to the string
		}

		return messageResult;
	}
}
