package logic;

public class Station {
	private String name;
	private int number;
	
	public Station(String name, int number) { // New station constructor
		setName(name);
		setNumber(number);
	}
	
	public void setName(String name) { // Station name setter
		this.name=name;
	}
	
	public String getName() { // Station name getter
		return name;
	}
	
	public void setNumber(int number) { // Station number setter
		if (number < 0) {
			throw new IllegalArgumentException("Invalid station number.");
		}
		this.number=number;
	}
	
	public int getNumber() { // Station number getter
		return number;
	}
	
}
