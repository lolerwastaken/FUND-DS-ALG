package Simulation;
import Queue.MyQueue;

public class SimulateQueue {

	public CustomerInfo[][] allEvents; //events in each and every queue
	public MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		//TODO: implement this method.
        for (int i = 0; i < allEvents.length; i++) { // Iterate through every array
            CustomerInfo[] events = allEvents[i]; // allEvents are an array of an array of CustomerInfo
            MyQueue queue = allQueues[i]; // allQueues are an array of all customer queues (initially empty)

            for (int j = 0; j < events.length; j++) {
                CustomerInfo event = events[j]; // Get the array of events

                if (event.getTime() >= t) break; // End if the time of event is greater or more than "t"

                if (event.getEvent() == 1) queue.insertLast(1); // Insert any data to the end of queue if the event type is 1.
                else if (event.getEvent() == -1) queue.removeFirst(); // Remove the first element of queue if the event type is -1;
            }
        }
	}
}

