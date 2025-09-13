package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) { // Ticket constructor
		setType(type);
		setStation(start,end);
	}
	
	public int getType() { // Ticket type getter
		return type;
	}
	
	public int getPricePerStation() { // Price per station getter
		return priceperstation;
	}
	
	public Station getStart() { // Start station getter
		return start;
	}
	
	public Station getEnd() { // End station getter
		return end;
	}
	
	public void setType(int type) { // Ticket type setter
		this.type=type;
	}
	
	public void setStation(Station start,Station end) { // Starting and end station setter
		this.start=start;
		this.end=end;
	}
	
	public double calculatePrice() { // Calculate price for all ticket types
		if (!isStationValid(start, end)) {
			throw new IllegalArgumentException("Invalid station selection, please try again.");
		}

		int distance = getStationDistance(start, end);
		double price = 0;

		switch (type) {
			case 0: // Student ticket
				price = 30*distance;
				if (distance > 4) {
					price *= 0.8; // If trip is more than 4 stations, get 20% discount
				}
				break;
			case 1: // Adult ticket
				price = 30*distance; // Normal price, no discount
				break;
			case 2: // Elderly ticket
				if (distance > 6) {
					throw new IllegalArgumentException("Elderly ticket cannot be bought for trips longer than 6 stations, please try again.");
				}
				price = 25*distance*0.6; // Elders get 40% discount
				break;
			default:
				throw new IllegalArgumentException("Invalid ticket type, please try again.");
		}
		return price;
	}
	
	public String getDescription() { // Ticket description
		String typename;
		
		switch(type) {
		
		case 0:
			typename = "Student";
			break;
		case 1:
			typename = "Adult";
			break;
		case 2:
			typename = "Elderly";
			break;
		default:
			typename = "Invalid";
		}
		
		return typename+" Ticket, from "+start.getName()+" to "+end.getName();
	}
	
	public boolean isStationValid(Station start,Station end) { // Verify if station is valid or not
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) { // Station distance getter
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
