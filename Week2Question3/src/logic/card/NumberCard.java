package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class NumberCard extends BaseCard {
	public NumberCard(CardColor color, CardSymbol symbol) {
		super(color);
		setSymbol(symbol);
	}
	
	
	@Override
	public void play() {
		GameLogic.getInstance().setTopCard(this);
	}
	
	@Override
	public boolean ruleCheck() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
        return this.getColor() == topCard.getColor() || this.getSymbol() == topCard.getSymbol();
	}
}
