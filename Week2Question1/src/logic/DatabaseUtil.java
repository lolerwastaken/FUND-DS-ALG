package logic;

import java.util.ArrayList;

public class DatabaseUtil {
	public static boolean isPlayerExists(ArrayList<Player> playerList, String name) {
		for(Player p: playerList) {
			if(p.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isRegionExists(ArrayList<Region> regionList, String name) {
		for(Region r: regionList) {
			if(r.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}
}
