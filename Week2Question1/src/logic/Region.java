package logic;

import java.util.ArrayList;

public class Region {
	private String name;
	private ArrayList<Player> playerList;
	private ArrayList<Quest> questList;
	
	public Region(String name) {
		setName(name);
		playerList = new ArrayList<>();
		questList = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		if (name.isBlank()) { this.name="Nowhere"; }
		else { this.name=name; }
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList=playerList;
	}
	
	public ArrayList<Quest> getQuestList() {
		return questList;
	}
	
	public void setQuestList(ArrayList<Quest> questList) {
		this.questList=questList;
	}
	
	public int getPlayerCount() {
		return playerList.size(); // Return the player count
	}
	
	public double getRegionRank() {
		double sum = 0;
		if (playerList.isEmpty()) { return 0; }
		for (Player p : playerList) {
			sum += p.getRank(); // Sum the rank of all players in a specified region
		}
		return Math.round((sum/playerList.size())*100.0)/100.0; // Round the average rank of specified region to 2 decimal points
	}
	
	public ArrayList<Quest> getAvailableQuests(Player viewer) {
		ArrayList<Quest> availableQuests = new ArrayList<>();
		for (Quest q : questList) {
			if (q.getStatus() == Status.AVAILABLE && q.getAuthor() != viewer) { 
				availableQuests.add(q); // Add any available quests to the quest lsit
			}
		}
		return availableQuests; // Show all available quests
	}
	
	public void addPlayerToRegion(Player p) {
		playerList.add(p); // Add player to a specified region
	}
	
	public void addQuestToRegion(Quest q) {
		questList.add(q); // Add quest to a specified region
	}
}
