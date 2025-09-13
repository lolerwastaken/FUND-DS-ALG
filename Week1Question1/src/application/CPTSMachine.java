package application;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Station;
import logic.Ticket;

public class CPTSMachine {
	private static ArrayList<Station> stationlist;
	private static ArrayList<Ticket> ticketlist;
	
	private static int totalStationNumber = 7;
	
	private static boolean isEnd = false;
	
	private static Scanner kb =  new Scanner(System.in);
	
	public static void main(String[] ang) {
		initializeData();
		
		while(!isEnd) {
		System.out.println("===========CPTS Ticket Machine===========");
		System.out.println("What are you doing today?");
		System.out.println("[1] Add Station");
		System.out.println("[2] Show All Station");
		System.out.println("[3] Buy Ticket");
		System.out.println("[4] List All Bought Tickets");
		System.out.println("[5] Quit");
		System.out.print("Please select your option:\t");
		
		int command = kb.nextInt();
		
		kb.nextLine();
		System.out.println("=========================================");
		
		switch(command) {
		case 1:
			handleAddStation();
			break;
		case 2:
			showAllStation();
			break;
		case 3:
			handleBuyTicket();
			break;
		case 4:
			showAllBoughtTicket();
			break;
		case 5:
			isEnd = true;
			break;
		default:
			System.out.println("Invalid Command.");
		}
		System.out.println("=========================================\n");
		}
			
	}
	
	public static void initializeData() {
		ticketlist = new ArrayList<Ticket>(); // Array list of bought tickets
		
		stationlist = new ArrayList<Station>(); // Array list of available stations
		stationlist.add(new Station("Siam",0));
		stationlist.add(new Station("Chit Lom",1));
		stationlist.add(new Station("Ploen Chit",2));
		stationlist.add(new Station("Nana",3));
		stationlist.add(new Station("Asoke",4));
		stationlist.add(new Station("Prom Phong",5));
		stationlist.add(new Station("Thong Lor",6));
		stationlist.add(new Station("Ekkamai",7));
	}
	
	public static boolean addStation(String name) {
		if (isStationExisted(name)) {
			return false;
		}
		stationlist.add(new Station(name, ++totalStationNumber));
		return true;
	}
	
	public static boolean isStationExisted(String name) {
		for (Station s : stationlist) {
			if (s.getName().equalsIgnoreCase(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean buyTicket(int type, Station start, Station end) { 
		Ticket ticket = new Ticket(type, start, end);
		if(ticket.isStationValid(start, end)) {
			ticketlist.add(ticket);
			System.out.println("Bought "+ticket.getDescription()+", for "+ticket.calculatePrice()+" Baht!");
			return true;
		}else {
			System.out.println("This ticket cannot be bought.");
			return false;
		}
	}
	
	public static void showAllStation() {
		int n = 0;
		for(Station s:stationlist) {
			System.out.println("["+n+"] "+s.getName());
			n++;
		}
	}
	
	public static void handleAddStation() {
		System.out.print("Please enter new station name:\t");
		String name = kb.nextLine();
		boolean issuccess = addStation(name);
		if(issuccess) {
			System.out.println("Station No. "+totalStationNumber+": "+name+" has been added successfully!");
		}else {
			System.out.println("Error adding station named "+name+".\nStation with the same name already exists!");
		}
	}
	
	public static void showAllBoughtTicket() {
		int n = 0;
		if(ticketlist.isEmpty()) {
			System.out.println("You have not bought any ticket yet.");
		}else {
			for(Ticket t:ticketlist) {
				System.out.println("["+(n+1)+"] "+t.getDescription());
				n++;
			}
		}
	}
	
	public static void handleBuyTicket() {
		System.out.println("What ticket type are you buying?:\t");
		System.out.println("[1] Student");
		System.out.println("[2] Adult");
		System.out.println("[3] Elderly");
		System.out.print("Please select your option:\t");
		int type = kb.nextInt();
		kb.nextLine();
		
		System.out.println("=========================================");
		if(type<4) {
			try {
				showAllStation();
				System.out.print("Please select the starting station:\t");
				int command = kb.nextInt();
				kb.nextLine();
				Station start = stationlist.get(command);
				System.out.print("Please select the ending station:\t");
				command = kb.nextInt();
				kb.nextLine();	
				Station end = stationlist.get(command);
				
				buyTicket(type-1,start,end);
				

				}catch (Exception e) {
					System.out.println("Your ticket is invalid.");
				}
		}else {
			System.out.println("Invalid Ticket Type.");
		} 
	}

	public static ArrayList<Station> getStationlist() {
		return stationlist;
	}


	public static ArrayList<Ticket> getTicketlist() {
		return ticketlist;
	}


	public static int getTotalStationNumber() {
		return totalStationNumber;
	}
}
