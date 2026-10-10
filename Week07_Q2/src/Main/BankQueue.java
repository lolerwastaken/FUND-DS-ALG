package Main;

import Deq.DeQ;
public class BankQueue { // must work for any implementation of DeQ
	public DeQ[] counters;
	public DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
        int totalCustomers = 0;
        int totalQueues = counters.length + 1;

        for (int i = 0; i < counters.length; i++) {
            DeQ counter = counters[i];
            int numOfCustomers = counter.size();
            totalCustomers += numOfCustomers;
        }

        double neededQueueLength = (double) totalCustomers / totalQueues;
        int queueIntegerValue = (int) Math.floor(neededQueueLength);
        double difference = neededQueueLength - queueIntegerValue;

        if (difference < 0.5) neededQueueLength = queueIntegerValue;
        else if (difference >= 0.5) neededQueueLength = queueIntegerValue + 1;

        for (int i = 0; i < counters.length; i++) {
            DeQ counter = counters[i];
            int numOfCustomersInCounter = counter.size();

            if (special.size() >= neededQueueLength) return;

            int keepCount = (int) Math.min(neededQueueLength, numOfCustomersInCounter);
            int[] kept = new int[keepCount];

            for (int k = 0; k < keepCount; k++) {
                kept[k] = counter.removeFirst();
            }

            while (!counter.isEmpty() && (special.size() < neededQueueLength)) {
                int data = counter.removeFirst();
                special.insertLast(data);
            }

            for (int k = keepCount - 1; k >= 0; k--) {
                counter.insertFirst(kept[k]);
            }
        }

        while (special.isEmpty() && counters.length > 0) {
            DeQ lastCounter = counters[counters.length - 1];
            if (!lastCounter.isEmpty()) {
                int data = lastCounter.removeLast();
                special.insertLast(data);
            }
        }
    }
}
