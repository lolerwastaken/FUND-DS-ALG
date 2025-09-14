package logic;

import java.util.ArrayList;

public class Channel {
	private String name;
	private ArrayList<Message> messageList;
	
	public Channel(String name) {
		setName(name);
		messageList = new ArrayList<>();
	}
	
	public void addMessage(Message message) {
		messageList.add(message);
	}
	
	public void setName(String name) {
		if (name.isBlank()) {
			this.name="off-topic";
		}
		else {
			this.name=name;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public int getMessageCount() {
		return messageList.size();
	}
	
	public ArrayList<Message> getMessageList() {
		return messageList;
	}
	
}
