package logic;

public class Quest {
	private Player author;
	private Region region;
	private String name;
	private String description;
	private Status status;
	private int rank;
	
	public Quest(Player author, Region region, String name, String description) {
		this.setAuthor(author);
		this.setRegion(region);
		this.setName(name);
		this.setDescription(description);
		this.setStatus(Status.AVAILABLE);
		this.setRank(author.getRank());
	}
	
	public Player getAuthor() {
		return author;
	}
	public void setAuthor(Player author) {
		this.author = author;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
	
}
