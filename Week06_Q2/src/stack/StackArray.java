package stack;

import myInterface.MyStack;

public class StackArray implements MyStack {
	private int[] theArray;
	private int currentSize;
	private static final int DEFAULT_SIZE = 10;
	
	public StackArray(){ // create an empty stack
		this(DEFAULT_SIZE);
	}
	
	public StackArray(int intendedCapacity){
		theArray = new int[intendedCapacity];
		currentSize =0;
	}
	
	public StackArray(int[] theArray, int currentSize) {
		super();
		this.theArray = theArray;
		this.currentSize = currentSize;
	}

	public int[] getTheArray() {
		return theArray;
	}

	public void setTheArray(int[] theArray) {
		this.theArray = theArray;
	}

	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}
	
	public boolean isEmpty(){
		return currentSize ==0;
	}
	
	public boolean isFull(){
		return currentSize == theArray.length;
	}
	
	public void makeEmpty(){
		theArray = new int[DEFAULT_SIZE];
		currentSize =0;
	}
	
	public int top() throws MyStackException {
		if(isEmpty())
			throw new MyStackException();
		return theArray[currentSize-1];
	}
	
	public void pop() throws MyStackException {
		if(isEmpty())
			throw new MyStackException();
		currentSize--;
	}
	
	public void doubleCapacity(){ //resize array to twice the original size 
		int[] temp = new int[theArray.length*2];
		System.arraycopy(theArray, 0, temp, 0, theArray.length);
		theArray = temp;
	}
	
	public void push(int data) throws Exception {
		if(isFull())
			doubleCapacity();
		theArray[currentSize] = data;
		currentSize++;
	}

    public void removeRange(int i, int j) throws Exception {
        if (i < 0 || j >= currentSize || i > j) throw new Exception();

        int rangeSize = j - i + 1; // Get removal range size
        int start = (currentSize - 1) - j; // Flip the end of range as the array's start
        int end = (currentSize - 1) - i; // Flip the start of range as the array's end

        int numsToShift = (currentSize - 1) - end; // Count how many elements are above array's "end"

        for (int k = 0; k < numsToShift; k++) {
            theArray[start + k] = theArray[end + 1 + k]; // Move every element above the range down, removing the range elements
        }
        currentSize -= rangeSize; // Reduce array size by the range size
    }
}


