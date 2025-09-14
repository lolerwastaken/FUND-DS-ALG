package logic.game;

import java.util.ArrayList;
import java.util.Collections;

import logic.card.BaseCard;
import logic.card.DrawTwoCard;
import logic.card.NumberCard;
import logic.utility.GameLogicUtility;

public class GameLogic {
	
	private ArrayList<BaseCard> deck;
	private ArrayList<BaseCard> hand;
	
	private BaseCard topCard;
	
	private static GameLogic instance = null;
	
	
	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}
	
	private GameLogic() {
		deck = new ArrayList<BaseCard>();
		hand = new ArrayList<BaseCard>();
	}
	
	public void draw(int number) {
		if(number > deck.size()) {
			System.out.println(deck.size()+" Draw !!");
			for(int i = 0; i < deck.size(); i++) {
				hand.add(deck.get(i));
			}
			deck.clear();
		}
		else {
			System.out.println(number+" Draw !!");
			while(number > 0) {
				hand.add(deck.get(0));
				deck.remove(0);
				number--;
			}
		}
	}
	
	public void gameStart() {
		//add red cards to deck
		this.deck.add(new NumberCard(CardColor.RED,CardSymbol.ONE));
		this.deck.add(new NumberCard(CardColor.RED,CardSymbol.TWO));
		this.deck.add(new NumberCard(CardColor.RED,CardSymbol.THREE));
		this.deck.add(new NumberCard(CardColor.RED,CardSymbol.FOUR));
		this.deck.add(new DrawTwoCard(CardColor.RED));
		//add yellow cards to deck
		this.deck.add(new NumberCard(CardColor.YELLOW,CardSymbol.ONE));
		this.deck.add(new NumberCard(CardColor.YELLOW,CardSymbol.TWO));
		this.deck.add(new NumberCard(CardColor.YELLOW,CardSymbol.THREE));
		this.deck.add(new NumberCard(CardColor.YELLOW,CardSymbol.FOUR));
		this.deck.add(new DrawTwoCard(CardColor.YELLOW));
		//add blue cards to deck
		this.deck.add(new NumberCard(CardColor.BLUE,CardSymbol.ONE));
		this.deck.add(new NumberCard(CardColor.BLUE,CardSymbol.TWO));
		this.deck.add(new NumberCard(CardColor.BLUE,CardSymbol.THREE));
		this.deck.add(new NumberCard(CardColor.BLUE,CardSymbol.FOUR));
		this.deck.add(new DrawTwoCard(CardColor.BLUE));
		//add green cards to deck
		this.deck.add(new NumberCard(CardColor.GREEN,CardSymbol.ONE));
		this.deck.add(new NumberCard(CardColor.GREEN,CardSymbol.TWO));
		this.deck.add(new NumberCard(CardColor.GREEN,CardSymbol.THREE));
		this.deck.add(new NumberCard(CardColor.GREEN,CardSymbol.FOUR));
		this.deck.add(new DrawTwoCard(CardColor.GREEN));
		
		Collections.shuffle(deck);
		
		for(int i = 0;i < this.deck.size();i++) {
			if(this.deck.get(i) instanceof NumberCard) {
				setTopCard(this.deck.get(i));
				this.deck.remove(i);
				break;
			}
		}
		
		draw(5);
	}
	
	public boolean checkDrawRule() {
		return GameLogicUtility.drawRule();
	}
	
	public ArrayList<BaseCard> getDeck() {
		return deck;
	}

	public void setDeck(ArrayList<BaseCard> deck) {
		this.deck = deck;
	}

	public ArrayList<BaseCard> getHand() {
		return hand;
	}

	public void setHand(ArrayList<BaseCard> hand) {
		this.hand = hand;
	}

	public BaseCard getTopCard() {
		return topCard;
	}

	public void setTopCard(BaseCard topCard) {
		this.topCard = topCard;
	}

	public boolean isGameOver() {
		if(this.getHand().size() == 0 || this.getDeck().size() == 0) {
			return true;
		}
		return false;
	}
	

}
