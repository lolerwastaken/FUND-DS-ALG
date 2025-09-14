package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;

public abstract class BaseCard {
	private CardColor color;
	private CardSymbol symbol;
	
	public BaseCard(CardColor color) {
		setColor(color);
	}
	
	public abstract void play();
	
	public abstract boolean ruleCheck();
	
	public void setColor(CardColor color) {
		this.color=color;
	}
	
	public CardColor getColor() {
		return color;
	}
	
	public void setSymbol(CardSymbol symbol) {
		this.symbol=symbol;
	}
	
	public CardSymbol getSymbol() {
		return symbol;
	}
}
