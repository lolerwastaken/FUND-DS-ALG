package main;

import java.util.Scanner;

import logic.Database;
import logic.DatabaseUtil;
import logic.Player;
import logic.Quest;
import logic.Region;
import logic.Status;

public class Main {

	private static Database dataBase;
	
	private static Scanner sc = new Scanner(System.in);
	
	private static Player currentUser = null;
	
	public static void main(String[] args) {
		dataBase = new Database();
		populateDatabase();
		
		boolean isFinished = false;
		
		System.out.println("Quest management system.");
		
		while(!isFinished) {
			
			if(currentUser!=null) {
				
				boolean hasOnGoingQuest = currentUser.getCurrentQuest()!=null;
				
				System.out.println("===============================");
				System.out.println("Welcome, "+currentUser.getName()+"!");
				System.out.println("Your point is "+currentUser.getScore()+", RANK "+currentUser.getRank());
				if(hasOnGoingQuest) {
					System.out.println("You have the current ongoing quest: "+currentUser.getCurrentQuest().getName());
				}else {
					System.out.println("You don't have the ongoing quest.");
				}
				System.out.println("What are you going to do?");
				System.out.println("===============================");
				System.out.println("1) Edit Name");
				if(hasOnGoingQuest) {
					System.out.println("2) Manage Quest Status");
				}else {
					System.out.println("2) Take On a Quest");
				}
				System.out.println("3) Post Quest");
				System.out.println("4) View Statistics");
				System.out.println("5) Log Out");
				System.out.println("===============================");
				int choice = getChoiceInput();
				switch(choice) {
				case 1:
					editPlayerName(currentUser);
					break;
				case 2:
					if(hasOnGoingQuest) {
						manageQuestStatus(currentUser);
					}else {
						takeOnQuest(currentUser);
					}
					break;
				case 3:
					postQuest(currentUser);
					break;
				case 4:
					viewStatus();
					break;
				case 5:
					currentUser = null;
					break;
				default:
					System.out.println("Error: Invalid Choice");

					break;
				}
			}else {
				System.out.println("===============================");
				System.out.println("Welcome, Guest!");
				System.out.println("What are you going to do?");
				System.out.println("===============================");
				System.out.println("1) Log In");
				System.out.println("2) View Statistics");
				System.out.println("3) Exit Program");
				System.out.println("===============================");
				int choice = getChoiceInput();
				switch(choice) {
				case 1:
					logInPlayer();
					break;
				case 2:
					viewStatus();
					break;
				case 3:
					isFinished = true;
					break;
				default:
					System.out.println("Error: Invalid Choice");

					break;
				}
			}
			
			
		}
		
		
	}
	
	private static void logInPlayer() {
		System.out.println("===============================");
		System.out.println("Please pick the Player Log In.");
		System.out.println("===============================");
		showPlayerList();
		System.out.println("===============================");
		int choice = getChoiceInput()-1;
		int maxChoice = dataBase.getPlayerList().size();
		if(choice<maxChoice&&choice>-1) {
			currentUser = dataBase.getPlayerList().get(choice);
		}else if(choice==maxChoice) {
			currentUser = registerPlayer();
		}else{
			System.out.println("Error: Invalid Choice");
		}
	}
	
	private static void showPlayerList() {
		int i = 1;
		for(Player p:dataBase.getPlayerList()) {
			System.out.println(i+") "+p.getName());
			i++;
		}
		System.out.println(i+") Register New Player");
	}
	
	private static Region getRegionInput() {
		Region region = null;
		String name;
		while(region==null) {
			System.out.println("Enter the Region name.");
			name = getStringInput();
			region = dataBase.getRegionByName(name);
			if(region==null) {
				System.out.println("Error: Region with the name "+name+" does not exist.");
			}
		}
		return region;
	}
	
	private static Player registerPlayer() {
		System.out.println("Enter the new Player Name");
		String name = getStringInput();
		Region region = getRegionInput();
		
		try{
			Player p = dataBase.addPlayer(name, region);
			System.out.println("Player "+p.getName()+" has been created!");
			return p;
		}catch(Exception e) {
			System.out.println("Could not create the player: The player with the name "+name+" already exists.");
			return null;
		}
	}
	
	private static void editPlayerName(Player p) {
		System.out.println("Enter the new name (Please leave it empty if unedited)");
		String name = getStringInput();
		
		if(!name.isBlank() && !name.equals(p.getName())) {
			if(!DatabaseUtil.isPlayerExists(dataBase.getPlayerList(),name)) {
				p.setName(name);
				System.out.println("Successfully changing the player name to "+name+".");
			}else {
				System.out.println("Could not rename the player: The other player with the name "+name+" already exists.");
			}
		}
	}
	
	private static void manageQuestStatus(Player p) {
		Quest currentQuest = p.getCurrentQuest();
		System.out.println("Your Current ongoing quest is: "+currentQuest.getName());
		System.out.println("What are you going to do?");
		System.out.println("===============================");
		System.out.println("1) Mark Current Quest as Finished");
		System.out.println("2) Decline Current Quest");
		System.out.println("3) Back");
		System.out.println("===============================");
		int choice = getChoiceInput();
		switch(choice) {
		case 1:
			currentQuest.setStatus(Status.FINISHED);
			p.addScore((p.getCurrentQuest().getRank()+1)*500);
			p.setCurrentQuest(null);
			break;
		case 2:
			currentQuest.setStatus(Status.AVAILABLE);
			p.setCurrentQuest(null);
			break;
		case 3:
			break;
		default:
			System.out.println("Error: Invalid Choice");

			break;
		}
	}

	private static void takeOnQuest(Player p) {
		System.out.println("===============================");
		System.out.println("Which Region would you like to take on the quest?");
		System.out.println("===============================");
		showRegionList();
		System.out.println("===============================");
		int choice = getChoiceInput()-1;
		int maxChoice = dataBase.getRegionList().size();
		if(choice<maxChoice&&choice>=0) {
			Region region = dataBase.getRegionList().get(choice);
			if(region.getAvailableQuests(p).size()>0) {
				System.out.println("===============================");
				System.out.println("Select the quest you would like to take");
				System.out.println("===============================");
				showQuestList(region, p);
				System.out.println("===============================");
				choice = getChoiceInput()-1;
				maxChoice = region.getAvailableQuests(p).size();
				
				if(choice<maxChoice&&choice>=0) {
					Quest quest = region.getAvailableQuests(p).get(choice);
					System.out.println("===============================");
					System.out.println("Quest Detail");
					System.out.println(quest.getName());
					System.out.println("Location: "+quest.getRegion().getName()+"  Rank: "+quest.getRank());
					System.out.println("Author: "+quest.getAuthor().getName());
					System.out.println(quest.getDescription());
					System.out.println("===============================");
					System.out.println("Do you accept this quest? (Y/N)");
					System.out.println("===============================");
					String choice2 = getStringInput().toLowerCase();
					switch(choice2) {
					case "y":
						p.setCurrentQuest(quest);
						quest.setStatus(Status.ACTIVE);
						System.out.println("You accept the quest!");
						break;
					case "n":
						break;
					default:
						System.out.println("Error: Invalid Choice. Going back to main menu");
					}
				}else{
					System.out.println("Error: Invalid Choice");
				}
			}else {
				System.out.println("Error: There are no available quest in this region.");
			}
		}else{
			System.out.println("Error: Invalid Choice");
		}
	}
	
	private static void showRegionList() {
		int i = 1;
		for(Region p:dataBase.getRegionList()) {
			System.out.println(i+") "+p.getName());
			i++;
		}
	}
	
	private static void showQuestList(Region r, Player viewer) {
		int i = 1;
		for(Quest q:r.getAvailableQuests(viewer)) {
			System.out.println(i+") "+q.getName());
			i++;
		}
	}
	
	private static void postQuest(Player p) {
		System.out.println("Enter the Quest Name");
		String name = getStringInput();
		System.out.println("Enter the Quest Description");
		String desc = getStringInput();
		System.out.println("===============================");
		System.out.println("Please pick the Quest's Region");
		showRegionList();
		System.out.println("===============================");
		int choice = getChoiceInput()-1;
		int maxChoice = dataBase.getRegionList().size();
		if(choice<maxChoice&&choice>=0) {
			Region region = dataBase.getRegionList().get(choice);
			dataBase.addQuest(p, region, name, desc);
		}else {
			System.out.println("Error: Invalid Choice.");
		}
	}
	
	private static void viewStatus() {
		System.out.println("===============================");
		System.out.println("Please pick Region you would like to view.");
		showRegionList();
		System.out.println("===============================");
		int choice = getChoiceInput()-1;
		int maxChoice = dataBase.getRegionList().size();
		if(choice<maxChoice&&choice>=0) {
			Region region = dataBase.getRegionList().get(choice);
			printRegionStatus(region);
		}else {
			System.out.println("Error: Invalid Choice.");
		}
	}
	
	private static void printRegionStatus(Region r) {
		System.out.println("Region name: "+r.getName());
		System.out.println("Player Count: "+r.getPlayerCount()+" Average Rank: "+r.getRegionRank());
	}
	
	private static int getChoiceInput() {
		System.out.print(">> ");
		int answer = sc.nextInt();
		sc.nextLine();
		return answer;
	}
	
	private static String getStringInput() {
		System.out.print(">> ");
		String answer = sc.nextLine();
		return answer;
	}
	
	private static void populateDatabase() {
		dataBase.addRegion("Asia");
		dataBase.addRegion("Africa");
		dataBase.addRegion("Australia");
		dataBase.addRegion("Europe");
		dataBase.addRegion("North America");
		dataBase.addRegion("South America");
		try {
			dataBase.addPlayer("Chrono", dataBase.getRegionByName("Asia"));
			dataBase.addPlayer("Tokoha", dataBase.getRegionByName("Asia"));
			dataBase.addPlayer("Shion", dataBase.getRegionByName("Asia"));
			dataBase.addPlayer("Jaime", dataBase.getRegionByName("Europe"));
		} catch (Exception e) {
			//This will not really happen
		}
		
		dataBase.getPlayerList().get(1).setScore(6000);
		dataBase.getPlayerList().get(2).setScore(12000);
		dataBase.getPlayerList().get(3).setScore(50000);
		
		dataBase.addQuest(dataBase.getPlayerList().get(3), dataBase.getRegionByName("Asia"), "I WANT TO EAT", "Can you help me find somewhere to eat?");
		dataBase.addQuest(dataBase.getPlayerList().get(1), dataBase.getRegionByName("Asia"), "Urgent Help Needed", "I need to prepare for the festival this weekend.");
	}

}
