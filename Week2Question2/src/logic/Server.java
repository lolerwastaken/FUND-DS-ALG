package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private User owner;
	private ArrayList<Channel> channelList;
	private ArrayList<User> memberList;
	
	public Server(String name, User owner, TemplateType template) {
		this.owner=owner;
		channelList = new ArrayList<>();
		memberList = new ArrayList<>();
		
		addUser(owner);
		setName(name);
		
		String channelName = "";
        switch (template) {
            case BASIC:
                channelName = "general";
                break;
            case GAMING:
                channelName = "gaming";
                break;
            case STUDY:
                channelName = "homework-help";
                break;
        }
        addChannel(owner, channelName);
   }
	
	public boolean isMemberInServer(User userToCheck) {
		if (userToCheck == null) { return false; }
		return memberList.contains(userToCheck);
	}


	public Channel addChannel(User user, String channelName) {
		if (user.equals(owner)) {
            Channel c = new Channel(channelName);
            channelList.add(c);
            return c;
        }
        return null;
	}
	
	public User addUser(User user) {
		if (!memberList.contains(user)) {
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        }
        return null;
	}
	
	public boolean kickUser(User kicker, User kicked) throws Exception {
		if (!kicker.equals(owner)) {
            throw new Exception("You can't do that!!! Only the owner is permitted to kick users.");
        }
		else if (!memberList.contains(kicked) || kicked.equals(owner)) {
            return false;
        }
		else {
			kicked.getJoinedServersList().remove(this);
			return memberList.remove(kicked);
		}
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name = owner.getName()+" home";
		} 
		else {
			this.name=name;
		}
	}
	 
	public String getName() {
		return name;
	}
	
	public User getOwner() {
		return owner;
	}
	
	public ArrayList<Channel> getChannelList() {
		return channelList;
	}
	
	public ArrayList<User> getMemberList() {
		return memberList;
	}
	
}
