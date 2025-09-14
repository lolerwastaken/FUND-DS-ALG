package logic.card;

import logic.game.CardColor;
import logic.game.CardSymbol;
import logic.game.GameLogic;

public class DrawTwoCard extends BaseCard {
	public DrawTwoCard(CardColor color) {
		super(color);
		setSymbol(CardSymbol.DRAW);
	}
	
	@Override
	public void play() {
		GameLogic.getInstance().setTopCard(this);
		GameLogic.getInstance().draw(2);
	}
	
	@Override
	public boolean ruleCheck() {
		BaseCard topCard = GameLogic.getInstance().getTopCard();
		return this.getColor() == topCard.getColor();
	}
}
