package logic;

public class Player {
	private String name;
	private int score;
	private Quest currentQuest;
	
	public Player(String name) {
		this.setName(name);
		this.setScore(0);
		this.setCurrentQuest(null);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		if(name.isBlank()) {
			this.name = "Anonymous";
		}else {
			this.name = name;
		}
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score<0) {
			score = 0;
		}
		this.score = score;
	}
	
	public void addScore(int score) {
		if(score<0) {
			score = 0;
		}
		this.score += score;
	}
	
	public Quest getCurrentQuest() {
		return currentQuest;
	}
	public void setCurrentQuest(Quest currentQuest) {
		this.currentQuest = currentQuest;
	}
	
	public int getRank() {
		if (this.score>10000) {
			return 4;
		}else if (this.score>7500 && this.score<=10000) {
			return 3;
		}else if (this.score>5000 && this.score<=7500) {
			return 2;
		}else if (this.score>2500 && this.score<=5000) {
			return 1;
		}else {
			return 0;
		}
	}
}
