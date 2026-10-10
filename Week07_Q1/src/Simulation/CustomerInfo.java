package Simulation;

public class CustomerInfo {
	public int time;
	public int event;
	
	public CustomerInfo(int time, int event) {
		super();
		this.time = time;
		this.event = event;
	}
	
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getEvent() {
		return event;
	}
	public void setEvent(int event) {
		this.event = event;
	}

}
