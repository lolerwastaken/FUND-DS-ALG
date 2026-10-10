package stack;

import myInterface.MyStack;

public class StackUtility {
    public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
        MyStack tempStack = new StackArray(); // can either use stack array or stack linked list
        int index = 0; // top index is initially 0

        // Loop through every element before it becomes empty
        while (!s.isEmpty()) {
            int value = s.top(); // Get top value of stack 's'
            if (index < i || index > j) { // Skip condition if it doesn't meet it
                tempStack.push(value); // Push value into a temp stack
            }
            index++; // Increment index by 1
            s.pop(); // Pop the value from the stack.
        }

        // Loop through every element of temp stack before it becomes empty
        while (!tempStack.isEmpty()) {
            s.push(tempStack.top()); // Push back into the original stack
            tempStack.pop(); // Pop the value
        }

        return s; // Return final stack

        // Example: s = [11, 9, 6, 8, 12] --> removeRange(s, 1 , 2)
        // Temp stack becomes [12, 8, 11]
        // Push the values back into the original stack and it becomes [11, 8, 12]
    }
}
