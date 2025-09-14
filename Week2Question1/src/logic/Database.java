package logic;

import java.util.ArrayList;

public class Database {
	private ArrayList<Player> playerList;
	private ArrayList<Region> regionList;
	
	
	public Database() {
		playerList = new ArrayList<>();
		regionList = new ArrayList<>();
	}
	
	public Database(ArrayList<Player> playerList, ArrayList<Region> regionList) {
		this.playerList=playerList;
		this.regionList=regionList;
	}
	
	public Player addPlayer(String name, Region region) throws Exception {
		if (DatabaseUtil.isPlayerExists(playerList, name)) {
            throw new Exception("Player already exists.");
        }
		Player p = new Player(name);
        playerList.add(p);
        region.addPlayerToRegion(p);
        return p;
	}
	
	public boolean addRegion(String name) {
		if (DatabaseUtil.isRegionExists(regionList, name)) {
            return false; // If inputted region already exists, return false
        }
        regionList.add(new Region(name));
        return true; // If inputted region is unique, return true
	}
	
	public Region getRegionByName(String name) {
		for (Region r : regionList) {
			if (r.getName().equals(name)) { 
				return r;
			}
		}
		return null;
	}
	
	public void addQuest(Player author, Region region, String name, String description) {
		Quest q = new Quest(author, region, name, description); // Add new quest to the quest list
        region.addQuestToRegion(q); // Adds that quest to a specified region
	}
	
	public ArrayList<Player> getPlayerList() {
		return playerList;
	}
	
	public void setPlayerList(ArrayList<Player> playerList) {
		this.playerList=playerList;
	}
	
	public ArrayList<Region> getRegionList() {
		return regionList;
	}
	
	public void setRegionList(ArrayList<Region> regionList) {
		this.regionList=regionList;
	}
}
