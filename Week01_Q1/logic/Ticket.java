package logic;

public class Ticket {
	private int type;
	private int priceperstation;
	
	private Station start;
	private Station end;
	
	public Ticket(int type,Station start,Station end) {
		setType(type);
		setStation(start,end);
	}
	
	public int getType() {
		return type;
	}
	
	public int getPricePerStation() {
		return priceperstation;
	}
	
	public Station getStart() {
		return start;
	}
	
	public Station getEnd() {
		return end;
	}
	
	public void setType(int type) {
		if (type < 0 || type > 2) {
            this.type = 1;
        } else {
            this.type = type;
        }

        switch (this.type) {
            case 0:
                priceperstation = 30; // Student
                break;
            case 1:
                priceperstation = 30;  // Adult
                break;
            case 2:
                priceperstation = 25; // Elderly
                break;
        }
	}
	
	public void setStation(Station start,Station end) {
		this.start = start;
        this.end = end;
	}
	
	public double calculatePrice() {
        if (!isStationValid(start, end)) { return -1; }

        int stationDistance = getStationDistance(start, end);

        double totalPrice = stationDistance*priceperstation;

        if (type == 0 && stationDistance > 4) {
            totalPrice = totalPrice * 0.80; // Student discount 20% if more than 4 stations
        }
        else if (type == 2) {
            totalPrice = totalPrice * 0.60; // Elderly discount 40%
        }

        return totalPrice;
	}
	
	public String getDescription() {
		String typename;
        if (!isStationValid(start, end)) {
            typename = "Invalid";
        } else {
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
        }
		return typename + " Ticket, from " + getStart().getName() + " to " + getEnd().getName();
	}
	
	public boolean isStationValid(Station start,Station end) {
		if (type == 2 && this.getStationDistance(start, end) > 6) {
			return false;
		}

		if (start == end || start.getName().equals(end.getName())) {
			return false;
		}
		return true;
	}
	
	public int getStationDistance(Station start,Station end) {
		return Math.abs(start.getNumber()-end.getNumber());
	}
	
}
